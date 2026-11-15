/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uet.construction.fleetops;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vehicle {
    private final String vin;
    private String model;
    private final Engine engine;                          // composition
    private final List<MaintenanceLog> maintenanceLogs;   // composition
    private Driver driver;                                // aggregation (optional)

    /** Takes RAW engine values, so the Engine is born inside the Vehicle. */
    public Vehicle(String vin, String model,
                   String engineNumber, int displacementCC, String fuelType) {
        this.vin = vin;
        this.model = model;
        this.engine = new Engine(engineNumber, displacementCC, fuelType);
        this.maintenanceLogs = new ArrayList<>();
    }

    public String getVin() { return vin; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    // ---- Composition: encapsulated modification ----
    public void addMaintenanceRecord(String logId, String description, double cost) {
        maintenanceLogs.add(new MaintenanceLog(logId, description, cost));
    }

    // ---- Composition: defensive accessors ----
    public Engine getEngine() {
        return new Engine(this.engine);   // never return this.engine
    }

    public List<MaintenanceLog> getMaintenanceHistory() {
        List<MaintenanceLog> copy = new ArrayList<>();
        for (MaintenanceLog log : maintenanceLogs) {
            copy.add(new MaintenanceLog(log));   // clone every item
        }
        return Collections.unmodifiableList(copy);
    }

    // ---- Aggregation: plain reference, no copying ----
    public void assignDriver(Driver driver) { this.driver = driver; }
    public void unassignDriver() { this.driver = null; }
    public Driver getDriver() { return driver; }

    @Override
    public String toString() {
        return "Vehicle{vin=" + vin + ", model=" + model + ", " + engine
                + ", logs=" + maintenanceLogs.size()
                + ", driver=" + (driver == null ? "none" : driver.getFullName()) + "}";
    }
}
