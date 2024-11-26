package Assigment1;

//purpose: the 'HealthService' class is the main class that manages the patients, facilities, and procedures.

import java.util.ArrayList; // import the arraylist class which is used to store the patients, facilities, and procedures
import java.util.List; // import the list class which is used to store the patients, facilities, and procedures

public class HealthService {
    private String name; // name of the health service
    private ArrayList<Patient> patients; // list of patients
    private ArrayList<MedicalFacility> facilities; // list of facilities
    private ArrayList<Procedure> procedures; //list of procedures

    public HealthService(String name) { // constructor
        this.name = name; // sets the name of the health service
        this.procedures = new ArrayList<>(); // creates a new arraylist to store the procedures
        this.patients = new ArrayList<>(); // creates a new arraylist to store the patients
        this.facilities = new ArrayList<>(); // creates a new arraylist to store the facilities
    }
    // Getters and Setters
    public String getName() { // getter method for the name of the health service
        return name; // returns the name of the health service
    }

    public void setName(String name) { // setter method for the name of the health service
        this.name = name; // setter method for the name of the health service
    }

    public List<Procedure> getProcedures() { // getter method for the procedures
        return procedures; // returns the procedures
    }

    public List<Patient> getPatients() { // getter method for the patients
        return patients; // returns the patients
    }

    public List<MedicalFacility> getFacilities() { // getter method for the facilities
        return facilities; // returns the facilities
    }

    // getters Method like 'getPatients()' and 'getFacilities()' provides access to the lists of patients, facilities and procedures.
    // These methods are called from other classes particularly from medicalconsole to retreive information
    
    
    // addPatient and addMedicalFacility methods

    public void addPatient(Patient patient) { // add patient method
        patients.add(patient); // adds the patient to the patients list
    }
    // addPatient(Patient patient) this method allows adding a new patient object to the 'patients' list.
    // It is called in the addPatient() method of MedicalConsole, linking user input to the underlying data structure.
    public void addMedicalFacility(MedicalFacility facility) { // add facility method
        facilities.add(facility);
    }
    // similar to 'addPatient()' this method allows adding a new medical facility object to the 'facilities' list.
    // this method adds 'MedicalFacility' objects to the 'facilities' list. 
    // this is invoked in the 'addFacility()' method of MedicalConsole.
    public void addProcedure(Procedure procedure) {
        procedures.add(procedure);
    }
    // similar to 'addPatient()' and 'addMedicalFacility()' this method allows adding a new procedure object to the 'procedures' list.
    // this method adds 'Procedure' objects to the 'procedures' list. 
    // this is invoked in the 'addProcedure()' method of MedicalConsole.
	public Patient findPatientById(int patientId) {
		return patients.stream()
				.filter(p -> p.getId() == patientId)
				.findFirst()
				.orElse(null);
	}
    //this method make sure that the 'patient' class has a method called 'getID()' that returns the patient's ID.
    //it then uses the 'findPatientById()' method to find the patient with the given ID and return it.
    // and i use stream and lambda method for this

    // Method to find a Facility by ID
    public MedicalFacility findfacility(int id) {
        return facilities.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
    }
    // this method searches for a facility by its ID and returns the corresponding facility object if found, or null if not found.
    
}