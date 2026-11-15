package com.uet.construction.fleetops;

import java.util.List;

public class FleetVerificationDriver {

    private static void check(String name, boolean condition) {
        System.out.println((condition ? "[PASS] " : "[FAIL] ") + name);
    }

    public static void main(String[] args) {
        testA();
        System.out.println();
        testB();
    }

    // Aggregation lifecycle independence
    private static void testA() {
        System.out.println("=== Test Case A: Aggregation ===");
        Driver d1 = new Driver("D1", "Ali Khan", "LIC-001");
        Driver d2 = new Driver("D2", "Sara Ahmed", "LIC-002");
        Vehicle v1 = new Vehicle("VIN1", "Hilux", "E-100", 2400, "Diesel");
        Vehicle v2 = new Vehicle("VIN2", "Corolla", "E-200", 1600, "Petrol");
        v1.assignDriver(d1);
        v2.assignDriver(d2);

        FleetDepot depot = new FleetDepot("DP1", "Abbottabad");
        depot.assignVehicle(v1);
        depot.assignVehicle(v2);
        System.out.println("Vehicles in depot: " + depot.getAssignedVehicles().size());

        depot = null;   // depot closes

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(d1);
        System.out.println(d2);
        check("Vehicle v1 still has its state", "VIN1".equals(v1.getVin()));
        check("Driver d1 still reachable", d1 == v1.getDriver());
        check("Vehicles can join another depot", reassign(v1));
    }

    private static boolean reassign(Vehicle v) {
        FleetDepot other = new FleetDepot("DP2", "Islamabad");
        other.assignVehicle(v);
        return other.getAssignedVehicles().contains(v);
    }

    // Composition + encapsulation
    private static void testB() {
        System.out.println("=== Test Case B: Composition ===");
        Vehicle v = new Vehicle("VIN3", "Civic", "E-300", 1800, "Petrol");
        v.addMaintenanceRecord("L1", "Oil change", 50.0);
        v.addMaintenanceRecord("L2", "Brake pads", 120.0);

        Engine leakedEngine = v.getEngine();
        Engine second = v.getEngine();
        System.out.println("leakedEngine hash: " + System.identityHashCode(leakedEngine));
        System.out.println("second copy hash : " + System.identityHashCode(second));
        check("Each getEngine() gives a different object", leakedEngine != second);

        leakedEngine.setEngineNumber("HACKED");
        leakedEngine.setDisplacementCC(1);
        System.out.println("Leaked (changed) : " + leakedEngine);
        System.out.println("Internal (real)  : " + v.getEngine());
        check("Internal engine unchanged", "E-300".equals(v.getEngine().getEngineNumber())
                && v.getEngine().getDisplacementCC() == 1800);

        List<MaintenanceLog> history = v.getMaintenanceHistory();
        boolean blocked = false;
        try {
            history.clear();
        } catch (UnsupportedOperationException e) {
            blocked = true;
        }
        check("clear() on returned list is blocked", blocked);

        history.get(0).setServiceCost(999999);   // mutate a cloned log
        check("Internal log cost unchanged",
                v.getMaintenanceHistory().get(0).getServiceCost() == 50.0);
        check("Internal history size still 2", v.getMaintenanceHistory().size() == 2);
    }
}