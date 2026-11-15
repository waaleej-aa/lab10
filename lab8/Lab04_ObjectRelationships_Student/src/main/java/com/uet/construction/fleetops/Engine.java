package com.uet.construction.fleetops;

/** Composition part: only meaningful inside a Vehicle. */
public class Engine {
    private String engineNumber;
    private int displacementCC;
    private String fuelType;

    public Engine(String engineNumber, int displacementCC, String fuelType) {
        this.engineNumber = engineNumber;
        this.displacementCC = displacementCC;
        this.fuelType = fuelType;
    }

    /** Copy constructor for defensive cloning. */
    public Engine(Engine other) {
        this(other.engineNumber, other.displacementCC, other.fuelType);
    }

    public String getEngineNumber() { return engineNumber; }
    public int getDisplacementCC() { return displacementCC; }
    public String getFuelType() { return fuelType; }

    public void setEngineNumber(String engineNumber) { this.engineNumber = engineNumber; }
    public void setDisplacementCC(int displacementCC) { this.displacementCC = displacementCC; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    @Override
    public String toString() {
        return "Engine{no=" + engineNumber + ", cc=" + displacementCC + ", fuel=" + fuelType + "}";
    }
}