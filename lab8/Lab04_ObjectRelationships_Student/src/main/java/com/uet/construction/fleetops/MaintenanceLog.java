package com.uet.construction.fleetops;

/** Composition part: a log entry has no meaning outside its Vehicle. */
public class MaintenanceLog {
    private String logId;
    private String serviceDescription;
    private double serviceCost;

    public MaintenanceLog(String logId, String serviceDescription, double serviceCost) {
        this.logId = logId;
        this.serviceDescription = serviceDescription;
        this.serviceCost = serviceCost;
    }

    /** Copy constructor for defensive duplication. */
    public MaintenanceLog(MaintenanceLog other) {
        this(other.logId, other.serviceDescription, other.serviceCost);
    }

    public String getLogId() { return logId; }
    public String getServiceDescription() { return serviceDescription; }
    public double getServiceCost() { return serviceCost; }

    public void setServiceDescription(String serviceDescription) { this.serviceDescription = serviceDescription; }
    public void setServiceCost(double serviceCost) { this.serviceCost = serviceCost; }

    @Override
    public String toString() {
        return "Log{id=" + logId + ", desc=" + serviceDescription + ", cost=" + serviceCost + "}";
    }
}