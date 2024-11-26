package Assigment1;


import java.util.Scanner; //import the scanner class which is used to read the person's input
import java.util.Map; //import the map class are used to map the menu options which is going to be shown down there 
import java.util.HashMap; //import hashmap which are used to map menu options to action however it stores keyvalue

public class MedicalConsole {
    private static HealthService healthService; //grabs the health service from the HealthService class 
    //  the class is used to store all the patients, facilities, and procedures for the programn.
    private static Scanner scanner; // object to reader user input from the console
    public static void main(String[] args) {
        healthService = new HealthService("Health Service"); //creates a brand new health service object
        scanner = new Scanner(System.in); //creates a new scanner object which can be used to read out user input


        System.out.println("Welcome to the Medical Console!");
        // Display a welcome message for users

        boolean exit = false; // boolean to check if the user wants to exit the program
        while (!exit) { // while loop is to keep the programn running until the user wants to exit so that is why it is like it is !exit
            showMenu(); //display the menu options to the user
            int choice = getChoice(); //get the user's choices from the programn

            Map<Integer, Runnable> menuMap = new HashMap<>(); //Just like from the import this creates a map which is used to import the menu options
            menuMap.put(1, () -> addObject()); //add object to the menu map
            menuMap.put(2, () -> listObjects()); //lists objects to the menu map
            menuMap.put(3, () -> visitFacility()); //visit facility to the menu map
            menuMap.put(4, () -> operateOnPatient()); //operate on patient to the menu map
            menuMap.put(5, () ->  {
                System.out.println("Goodbye!"); //exit the said programn and then close the scanner
                scanner.close(); //is used to close the scanner
            });
            
            menuMap.getOrDefault(choice, () -> System.out.println("ERROR CHOICE BUDDY")).run();
            // if the user enters an invalid option then it will return the user to the main menu
        }
        scanner.close(); //closes the scanner
        // this code uses menuMap (Map<Integer, Runnable>) to map the user's choice to the corresponding action.
        // Each option is mapped to a lambda that performs a specific action. An example can be
        // calling methods like addObject(), listObjects(), visitFacility(), operateOnPatient()  etc.
    }   // If user enters an ivalid choice,   a default lambda would say "Invalid option. Returning to main menu."
        // program continue until user ends the cycle by pressing 5 which says "GoodBye" 


        // another method which is not lambda =

        // switch(choice) {

        //         while (!exit) {
            //showMenu();
            //int choice = getChoice();
            //switch (choice) {
                //case 1:
                    //addObject();
                    //break;
                //case 2:
                    //listObjects();
                    //break;
                //case 3:
                    //visitFacility();
                    //break;
                //case 4:
                    //operateOnPatient();
                    //break;
                //case 5:
                    //exit = true;
                    //break;
                //default:
                    //System.out.println("Invalid choice. Please try again.");
                    //break;

    private static void showMenu() { //class for the menu which display the menu options for the user
        //and that is where i put the show menu for the user in the choices
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~"); //prints out the menu
        System.out.println("\nMenu:"); //user can use the menu
        System.out.println("1. Add Object"); // user can add object to the programn
        System.out.println("2. List Objects"); // user can list objects from the programn
        System.out.println("3. Visit Facility"); // user can visit a facility from the programn
        System.out.println("4. Operate on Patient"); // user can operate on a patient from the programn
        System.out.println("5. Exit"); // user can exit the programn
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");    //prints out the menu
        System.out.print("Enter your choice here: "); //user can enter the choices 
    }


    private static int getChoice() {
        while (!scanner.hasNextInt()) { //while loop is to ensure the user enters a valid number
            System.out.print("Please enter a valid number: "); //prompts the user to enter a valid number
            scanner.next(); //reads the user input and ensures it is an integer and if it  is not the prompt will ask to add for a valid number
        }
        return scanner.nextInt(); //returns the user's choice
    }
    // reads the user input and ensures it is an integer and if it  is not the prompt will ask to add for a valid number


   
    // Add Object Functionality
    private static void addObject() { //class for the add object menu which displays the menu options for the user
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nAdd Object:"); //user can add object to the programn
        System.out.println("1. Patient"); // user can add patient to the programn
        System.out.println("2. Medical Facility"); // user can add medical facility to the programn
        System.out.println("3. Add Procedure"); // user can add procedure to the programn
        System.out.println("4. Back to Main Menu"); //returns to main menu
        System.out.print("Enter your choice here: "); //what are the choices the user can enter


        int choice = getChoice();// gets the user's choice 
         
            Map<Integer, Runnable> ObjectMap = new HashMap<>(); // creates a map for the object menu
            ObjectMap.put(1, () -> addPatient()); //lambda expression for the patient option
            ObjectMap.put(2, () -> addFacility()); //Lambda expression for the medical facility option
            ObjectMap.put(3, () -> addProcedure()); //Lambda experession for to add an 
            ObjectMap.put(4, () -> backToMainMenu()); //Lambda expression for back to menu

            ObjectMap.getOrDefault(choice, () -> System.out.println("Invalid choice. Please try again.")).run();
            // in here the code uses Map<Integer, Runnable> Objectmap which is used to associate
            // the user's choice with the corresponding action to be taken. Each Lambda expression 
            // executes the corresponding action and the code then goes back to the main menu. 
            // an example of lambda in here is add Patient() or addProcedure().
            // The method is being called using .run(). If the choice is invalid, a default lambda
            // then prints an error message, as this method avoids repetitive if-else or switch statments 
            // which makes the code modular and extendable . 

            //this is the switch menu = (another method which can be used)
            //switch (choice) {
                //case 1:
                    //addPatient();
                    //break;
                //case 2:
                    //addFacility();
                    //break;
                //case 3:
                    //addProcedure();
                    //break;
                //default:
                    //System.out.println("Invalid choice. Please try again.");
                    //break;

    }


    private static void addPatient() {      //add patients class which by it's name add patients                    
        scanner.nextLine();  //clear the screen
        System.out.print("Enter patient name: "); //ask for the patient's name
        String name = scanner.nextLine(); //get the patient's name


        System.out.print("Is patient private? (Y/N): "); //ask if the patient is private
        boolean isPrivate = scanner.nextLine().equalsIgnoreCase("Y");
        //get the patient's privacy status


        Patient newPatient = new Patient(name, isPrivate); //create a new patient object
        healthService.addPatient(newPatient); //add the patient to the database
        System.out.println("Patient added successfully: " + newPatient);
    }   //this prompts the user for patient details and adds a new patient to heathservice
        

    private static void addFacility() { //add facility class which by it's name add facilities
        System.out.println("1. Add Hospital"); //menu display the choices for the prompt
        System.out.println("2. Add Clinic"); //menu display the choices for the prompt
        System.out.print("Enter your choice here: ");
        // menu display the choices for the prompt
        // option 1 is for hospital and option 2 is for clinic
        int choice = getChoice(); //get the user's choice from up there
        if (choice == 1) {  //if the user enters 1 then it will add a hospital
            addHospital(); //add a hospital prompt
        } else if (choice == 2) { // if not 1 then it will add a clinic
            addClinic(); //adds a clinic prompt
        } else { // else again it will print an error message
            System.out.println("ERROR CHOICE BUDDY"); // prints an error message of "ERORR CHOICE BUDDY"
        }
    }


    private static void addHospital() { //add hospital class which by it's name add hospital
        scanner.nextLine(); //clear the screen 
        System.out.print("Enter hospital name here: "); // asks you for the hospital name
        String name = scanner.nextLine(); // next line for scanner


        System.out.print("Enter admission probability (0.0 - 1.0): "); // asks you for the admission probability
        double probAdmit = scanner.nextDouble(); // next double for scanner


        Hospital newHospital = new Hospital(name, probAdmit); //create a new hospital object
        healthService.addMedicalFacility(newHospital); //add the hospital to the database
        System.out.println("Facility - Hospital added successfully: " + newHospital ); //prints the hospital name and the admission probability
    }                                                                               


    private static void addClinic() {
        scanner.nextLine(); //clear the screen
        System.out.print("Enter clinic name: "); // asks you for the clinic name
        String name = scanner.nextLine(); // next line for scanner


        System.out.print("Enter fee: "); // asks you for the clinic fee
        double fee = scanner.nextDouble(); // next double for scanner


        System.out.print("Enter gap percent (for public patients): "); // asks you for the gap percent
        double gapPercent = scanner.nextDouble(); //    next double for scanner


        Clinic newClinic = new Clinic(name, fee, gapPercent); //create a new clinic object
        healthService.addMedicalFacility(newClinic);  //add the clinic to the database
        System.out.println("Facility - Clinic added successfully: " + newClinic); //prints the clinic name and the fee
    }


    private static void addProcedure() { // class which is used to add procedure 
        scanner.nextLine(); //clear the screen
        System.out.print("Enter procedure name: "); // asks for the producer's name
        String name = scanner.nextLine(); //next line for scanner


        System.out.print("Enter procedure description: "); //asks for the procedure description
        String description = scanner.nextLine(); //next line for scanner


        System.out.print("Is the procedure elective? (Y/N): "); //asks for the procedure elective
        boolean isElective = scanner.nextLine().equalsIgnoreCase("Y"); //next line for scanner


        System.out.print("Enter procedure cost: "); //asks for the procedure cost
        double cost = scanner.nextDouble(); //next double for scanner


        Procedure newProcedure = new Procedure(name, description, cost, isElective);
        //create a new procedure object
        System.out.println("Procedure added successfully: " + newProcedure);
        //prints the procedure name and the procedure description
    }

    private static void backToMainMenu() {
        System.out.println("Exiting The Medical Console...");
        //prints the exiting message
        return;
        //returns to the main menu
    }
    //Conclusion for up here : AddHospital, AddClinic, AddProcedure, BackToMainMenu make up the functions

    // List Objects Functionality
    private static void listObjects() { //list objects
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~"); // prints a divider
        System.out.println("\nList Objects:"); // prints a header
        System.out.println("1. List Patients"); // prints the first option
        System.out.println("2. List Medical Facilities"); // prints the second option
        System.out.println("3. List Procedures"); // prints the third option
        System.out.println("4. Back to Main Menu"); // prints the fourth option
        System.out.println("Enter your choice: ");// prints the promptX
 

        int choice = getChoice();
        
        Map<Integer, Runnable> listMap = new HashMap<>();
        listMap.put(1, () -> healthService.getPatients().forEach(System.out::println));
        listMap.put(2, () -> healthService.getFacilities().forEach(System.out::println));
        listMap.put(3, () -> healthService.getProcedures().forEach(System.out::println));
        listMap.put(4, () -> backToMainMenu());

        listMap.getOrDefault(choice, () -> System.out.println("Invalid option. Returning to main menu.")).run();
    }
    // code which display a console based menu that allows the user to select a list of objects such as patients,
    // facilities, or procedures. The user can then select to return to the main menu or quit the application.
    // the user input is mapped to an action using HashMap

    //alternative code for the above code
    //switch (choice) {
       // case 1:
            //healthService.getPatients().forEach(System.out::println);
            //break;
        //case 2:
            //healthService.getFacilities().forEach(System.out::println);
            //break;
        //default:
           // System.out.println("Invalid option. Returning to main menu.");
   // }



   
    private static void visitFacility() { //visit facility class which by it's name visit facility
        System.out.print("Enter Patient ID: "); //prompts the user to enter the patient id
        int patientId = getChoice(); //retreives the patient id from the user
        Patient patient = healthService.getPatients().stream().filter(f -> f.getId() == patientId).findFirst().orElse(null);
        //searches through a list of patient(healthservice.getPatient), filters the patients based on matching patientID and returns the first matching patient or null if not found.                                                                         
        if (patient == null) {
            System.out.println("Patient not found!"); //prints the patient not found message
            return; //patients not found then returns
        }


        System.out.print("Enter Facility ID: "); //asked for the facility id
        int facilityId = getChoice(); //retreives the facility id from the user
        MedicalFacility facility = healthService.getFacilities().stream().filter(f -> f.getId() == facilityId).findFirst().orElse(null);
        //searches through a list of medical facility(healthservice.getFacilities), filters the facilities based on matching facilityID and returns the first matching facility or null if not found.
        if (facility == null) {  //if the facility is not found then it will print the facility not found message
            System.out.println("Facility not found!"); //prints the facility not found message
            return; //when facility is not found then it returns
        }


        boolean success = facility.visit(patient); //calls the visit method on the facility with the patients as a parameter.                                     
        System.out.println(success ? "Visit successful!" : "Visit registered, please return for consultation."); // prints visit success or visit registered
    }




    private static void operateOnPatient() { // this is the class for the Operate on Patient Menu
        System.out.println("~~~~~~~"); 
        System.out.println("\nOperate on Patient"); // prints out the message operate on patient
        System.out.println("1. Go Back"); // press 1 to go back 
        System.out.println("Please Enter Hospital ID or (press 1 to go back): "); //please enter the hospital id or go back
        System.out.println("~~~~~~~");

        int HospitalId = getChoice(); // this is the getChoice() method which is used to get the user's choice
        if(HospitalId == 1) return; // returns when user press 1 to go back
        
        MedicalFacility facility = healthService.findfacility(HospitalId); // this is the findfacility() method which is used to find the facility based on the HospitalId
        if (facility == null) { // if the facility is null then it will print the message "Hospital not found!"
            System.out.println("Hospital not found!"); // prints the message "Hospital not found!"
            return; // returns when the hospital is null/ facility is not found
        }
        
        System.out.println("Please Enter Patient ID:"); //prompts the user to enter the patient id
        int patientId = getChoice(); //retreives the patient id from the user
        Patient patient = healthService.getPatients() //searches through a list of patient(healthservice.getPatient), filters the patients based on matching patientID and returns the first matching patient or null if not found.
                .stream()  
                .filter(p -> p.getId() == patientId)
                .findFirst()
                .orElse(null);
        //The lambda expression is a short way to define the condition for filtering the 'patient' list. example is the 'p -> p.getId() == patientId'
        // it allows the code to effeciently search through the list of patients and retreive the one that matches the given ID or return 'null' if no patient exist.
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }
        //if the patient is not found then it will print the message "Patient not found!"
        System.out.println("Please Enter Procedure ID:");
        int procedureId = getChoice();
        Procedure procedure = healthService.getProcedures()
                .stream()
                .filter(p -> p.getId() == procedureId)
                .findFirst()
                .orElse(null);
        //The lambda expression is a short way to define the condition for filtering the 'procedure' list. example is the 'p -> p.getId() == procedureId'
        // it allows the code to effeciently search through the list of procedures and retre
        if (procedure == null) {
            System.out.println("Procedure not found!");
            return;
        }
        //if the procedure is not found then it will print the message "Procedure not found!"
        boolean success = facility.operateOnPatient(patient, procedure);
        System.out.println(success ? "Procedure successful!" : "Procedure registered, please return for consultation.");
        //prints the success message or the message "Procedure registered, please return for consultation."
    }
        
}





