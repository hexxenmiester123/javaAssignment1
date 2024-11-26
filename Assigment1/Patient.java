package Assigment1;
//purpose: represents a patient within the health service
public class Patient {
    private static int idCounter = 1; // Patient ID counter
    private int id; // Unique ID for each patient
    private String name; // Name of the patient
    private boolean isPrivate; // Indicates if the patient is private
    private double balance; // Balance of the patient
    private MedicalFacility currentFacility; // Current facility patient is visiting

    // Constructor
    public Patient(String name, boolean isPrivate) { // Constructor
        this.id = idCounter++; // Assign a unique ID to the patient
        this.name = name; // Set the patient's name
        this.isPrivate = isPrivate; // Set the patient's private status
        this.balance = 0.0; // Set the patient's balance to zero
        this.currentFacility = null; // Patient starts with no current facility
    }

    // Getters and setters
    // is used to access the patient's attributes
    public String getName() { // Returns the patient's name
        return name; // Returns the patient's name
    }

    public int getId() { 
        return id; // Returns the patient's ID
    }   

    public boolean isPrivate() {
        return isPrivate; // Returns the patient's private status
    }

    public double getBalance() {
        return balance; // Returns the patient's balance
    }

    public MedicalFacility getCurrentFacility() {
        return currentFacility; // Returns the patient's current facility
    }

    public void setCurrentFacility(MedicalFacility facility) {
        this.currentFacility = facility; // Sets the patient's current facility
    }

    public void addToBalance(double amount) {
        this.balance += amount; // Adds the specified amount to the patient's balance
    }

    @Override
    public String toString() { 
        return "Patient ID: " + id + ", Name: " + name + ", Private: " + isPrivate + ", Balance: " + balance;
    }
    //returns a string representation of the patient
}
