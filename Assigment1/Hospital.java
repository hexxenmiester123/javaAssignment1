package Assigment1;

//Purpose: This program will calculate the area of a rectangle and a circle
import java.util.Random; //import the Random class for generating random numbers
import java.util.ArrayList; // import the ArrayList class for storing data
import java.util.List; // import the List interface for storing data

public class Hospital extends MedicalFacility { // Hospital class
   
    // add probAdmit, list procedures
    private double probAdmit;// represents the value that represents the probability of admitting a patient.
    //This value is used to derive the probability of admitting a patient.
    private List<Procedure> procedures; // represents various be admitted when they visit the hospital.

    public Hospital(String name, double probAdmit) { // Constructor
        super(name); // Calls the constructor of the MedicalFacility class
        this.probAdmit = probAdmit; // initializes the hospital'sanem (inherited from 'MedicalFacility') and the admission probability
        this.procedures = new ArrayList<>(); // list to an empty list
    }

    @Override
    
    public boolean visit(Patient patient) { // visit() method
        Random random = new Random(); // creates a random number generator
        double randomNumber = random.nextDouble(); // generates a random number between 0 and 1
        if (randomNumber < probAdmit) { // if the random number is less than the admission probability
            patient.setCurrentFacility(this); // the patient is admitted to the hospital
            return true; // the method returns true
        } else { // if the random number is not less than the admission probability
            return false; // the method returns false
        }
    }
    // This method replicates the scenario of a patient attending the hospital – it creates a random number generated between 0 and 1. 
    //  In the case that this random number is less than the probAdmit, the patient is admitted (the hospital is set as the patient’s current facility), and the method returns true. And in that case, it returns false which indicates that the patient was not admitted.

    //list
    public void addProcedure(Procedure procedure) {
        procedures.add(procedure);
    }
    // This method adds a procedure to the list of procedures of the hospital.
    public List<Procedure> getProcedures() {
        return procedures;
    }
    // This method returns the list of procedures of the hospital.
    @Override
    public String toString() {
        return "Hospital " + id + " is " + name + " with " + procedures.size() + " procedures";
    }
    // This method returns a string representation of the hospital.
    


    
    
}