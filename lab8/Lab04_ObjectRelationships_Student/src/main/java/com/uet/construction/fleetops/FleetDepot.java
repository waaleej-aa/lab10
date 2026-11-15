package com.uet.construction.fleetops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Aggregation: the depot references vehicles but does not own their lifetime. */
public class FleetDepot {
    private final String depotId;
    private final String locationName;
    private final List<Vehicle> vehicles = new ArrayList<>();

    public FleetDepot(String depotId, String locationName) {
        this.depotId = depotId;
        this.locationName = locationName;
    }

    public String getDepotId() { return depotId; }
    public String getLocationName() { return locationName; }

    public void assignVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("vehicle must not be null");
        }
        if (!vehicles.contains(vehicle)) {   // no duplicates
            vehicles.add(vehicle);
        }
    }

    /** Only unlinks the reference; the Vehicle object itself is untouched. */
    public boolean releaseVehicle(Vehicle vehicle) {
        return vehicles.remove(vehicle);
    }

    public List<Vehicle> getAssignedVehicles() {
        return Collections.unmodifiableList(vehicles);
    }
}