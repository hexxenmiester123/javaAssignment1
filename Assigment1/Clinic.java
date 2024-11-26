package Assigment1;

//purpose of the code: it represents a clinic where patienrs can receive consultations.

public class Clinic extends MedicalFacility {
    private double fee; // cost of consultation per unit 
    private double gapPercent; // gap percentage for public patients

    public Clinic(String name, double fee, double gapPercent) { // constructor
        super(name); // calls the constructor of the parent class
        this.fee = fee; //  sets the fee
        this.gapPercent = gapPercent; // sets the gap percentage
    }

    @Override // super class method
    public boolean visit(Patient patient) { // so the visit() method checks if the patient is already registered at the clinic. It calculates the cost based on whether the patient is private or public.
        if (patient.getCurrentFacility() != this) { // if the patient is already registered at the clinic
            patient.setCurrentFacility(this);  // then the patient is registered at the clinic
            return false; // First-time registration
        } else {
            double cost = patient.isPrivate() ? fee : fee * (gapPercent / 100);
            patient.addToBalance(cost); //adds the cost to the patient's balance
            return true; // Consultation performed
        }
    }

    @Override
    // toString() method provides a string representaitoon of the clinic, which can  be used in 'MedicalConsole.java' to display the clinics in the console.
    public String toString() { return "Clinic{id=" + id + ", name='" + name + "', fee=" + fee + "}"; }
}

