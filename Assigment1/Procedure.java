package Assigment1;
//Purpose: represents a medical procedure within the health service

public class Procedure {
    // add id, name, description, cost and isElective
    private static int idCounter = 1; // ID counter for procedures
    private int id; // ID of the procedure
    private String name; // name of the procedure
    private String description; // description of the procedure
    private double cost; // cost of the procedure
    private boolean isElective; // indicates if the procedure is elective

    public Procedure(String name, String description, double cost, boolean isElective) {
        // Constructor
        this.id = idCounter++; // Sets the ID of the procedure
        this.name = name; // Sets the name of the procedure
        this.description = description; // Sets the description of the procedure
        this.cost = cost; // Sets the cost of the procedure
        this.isElective = isElective; // Sets the elective status of the procedure
    }

    public int getId() {
        return id; // Returns the ID of the procedure
    }

    public String getName() {
        return name; // Returns the name of the procedure
    }

    public String getDescription() {
        return description; // Returns the description of the procedure
    }

    public double getCost() {
        return cost; // Returns the cost of the procedure
    }

    public boolean isElective() {
        return isElective; // Returns the elective status of the procedure
    }

    @Override
    public String toString() {
        return "Procedure " + id + " is " + name + " with " + description + " and cost " + cost;
        // Returns a string representation of the procedure
    }
}
