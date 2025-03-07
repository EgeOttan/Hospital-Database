//-----------------------------------------------------
//Title: MedicalStaff Class
//Author:  Ege Ottan
////ID: 10168090218
//Section: 02
//Assignment: 3
//Description:This class represents a member of the medical staff with a first name, last name, and role.
//-----------------------------------------------------
class MedicalStaff implements Comparable<MedicalStaff> {
    private String firstName;
    private String lastName;
    private String role;

    /*
    // Summary: Initializes a MedicalStaff object with the specified
    // personal details and professional role.
    // Precondition: firstName, lastName, and role must be valid String values.
    // Postcondition: Creates an instance of MedicalStaff with the given details.
    */
    public MedicalStaff(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    /*
    // Summary: Combines the first and last names of the medical staff into a single string.
    // Precondition: None
    // Postcondition: Returns the full name of the medical staff
    // as a String in the format "firstName lastName".
    */
    public String getName() {
        return firstName + " " + lastName;
    }

    /*
    // Summary: Compares the names of two MedicalStaff objects to determine their order.
    // Precondition: other is a valid MedicalStaff object.
    // Postcondition: Returns a negative integer, zero, or a positive
    // integer as this object's name is less than, equal to, or greater
    // than the specified object's name.
    */

    public int compareTo(MedicalStaff other) {
        return this.getName().compareTo(other.getName());
    }

    /*
    // Summary: Returns a string representation of the MedicalStaff object.
    // Precondition: None
    // Postcondition: Returns a string displaying the staff member's full name and role.
    */

    public String toString() {
        return firstName + " " + lastName + ", " + role;
    }
}
