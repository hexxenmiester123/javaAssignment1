package Assigment1;

//Purpose: represents a medical facility (like a hospital or a clinic) within the health service

public abstract class MedicalFacility { // MedicalFacility class
    private static int idCounter = 1; // ID counter for medical facilities
    protected int id; // ID of the medical facility
    protected String name; // Name of the medical facility

    public MedicalFacility(String name) { // Constructor
        this.id = idCounter++; // Sets the ID of the medical facility
        this.name = name; // Sets the name of the medical facility
    }

    public abstract boolean visit(Patient patient);
    // visit() method is an abstract method that must be implemented by subclasses
    public int getId() { return id; }
    // returns the facility's ID
    public String getName() { return name; }
    //returns the facility's name
    @Override
    public String toString() { return "MedicalFacility{id=" + id + ", name='" + name + "'}"; }
    // returns a string representation of the facility
    public boolean operateOnPatient(Patient patient, Procedure procedure) {
        return true;
    }
    // operateOnPatient() method is an abstract method that must be implemented by subclasses
}
