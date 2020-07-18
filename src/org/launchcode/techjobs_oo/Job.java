package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    private final static String DATA_NOT_AVAILABLE = "Data not available";

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        checkIfFieldsAreEmpty();
        String[] dataFields = {this.name, this.employer.getValue(), this.positionType.getValue(), this.location.getValue(), this.coreCompetency.getValue()};
        int counter = 0;
        for (String df : dataFields) {
            if (df.contains(DATA_NOT_AVAILABLE)) {
                counter++;
            }
        }
        if (counter == 5) {
            return "\nOOPS! This job does not seem to exist.\n";
        }
        return "\nID: " + id +
                "\nName: " + name +
                "\nEmployer: " + employer.getValue() +
                "\nLocation: " + location.getValue() +
                "\nPosition Type: " + positionType.getValue() +
                "\nCore Competency: " + coreCompetency.getValue() +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    private void checkIfFieldsAreEmpty() {
        if (this.coreCompetency == null) {
            this.coreCompetency = new CoreCompetency(DATA_NOT_AVAILABLE);
        } else if (this.coreCompetency.getValue().isBlank() || this.coreCompetency.getValue().isEmpty()) {
            this.coreCompetency.setValue(DATA_NOT_AVAILABLE);
        }
        if (this.name == null || this.name.isEmpty() || this.name.isBlank()) {
            this.name = DATA_NOT_AVAILABLE;
        }
        if (this.employer == null) {
            this.employer = new Employer(DATA_NOT_AVAILABLE);
        } else if (this.employer.getValue().isBlank() || this.employer.getValue().isEmpty()) {
            this.employer.setValue(DATA_NOT_AVAILABLE);
        }
        if (this.location == null) {
            this.location = new Location(DATA_NOT_AVAILABLE);
        } else if (this.location.getValue().isBlank() || this.location.getValue().isEmpty()) {
            this.location.setValue(DATA_NOT_AVAILABLE);
        }
        if (this.positionType == null) {
            this.positionType = new PositionType(DATA_NOT_AVAILABLE);
        } else if (this.positionType.getValue().isBlank() || this.positionType.getValue().isEmpty()) {
            this.positionType.setValue(DATA_NOT_AVAILABLE);
        }
    }
}
