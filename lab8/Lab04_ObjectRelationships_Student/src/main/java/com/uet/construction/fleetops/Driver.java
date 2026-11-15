package com.uet.construction.fleetops;

/** Aggregation part: a Driver exists independently of any Vehicle. */
public class Driver {
    private String driverId;
    private String fullName;
    private String licenseNumber;

    public Driver(String driverId, String fullName, String licenseNumber) {
        this.driverId = requireText(driverId, "driverId");
        this.fullName = requireText(fullName, "fullName");
        this.licenseNumber = requireText(licenseNumber, "licenseNumber");
    }

    private static String requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " must not be null or blank");
        }
        return value;
    }

    public String getDriverId() { return driverId; }
    public String getFullName() { return fullName; }
    public String getLicenseNumber() { return licenseNumber; }

    public void setDriverId(String driverId) { this.driverId = requireText(driverId, "driverId"); }
    public void setFullName(String fullName) { this.fullName = requireText(fullName, "fullName"); }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = requireText(licenseNumber, "licenseNumber");
    }

    @Override
    public String toString() {
        return "Driver{id=" + driverId + ", name=" + fullName + ", license=" + licenseNumber + "}";
    }
}