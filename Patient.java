//-----------------------------------------------------
//Title: Patient Class
//Author:  Ege Ottan
////ID: 10168090218
//Section: 02
//Assignment: 3
//Description:This class represents a patient with a first name, last name, doctor name, visit date (day, month, year).
//-----------------------------------------------------
import java.util.ArrayList;
import java.util.List;
class Patient implements Comparable<Patient> {
    private String firstName;
    private String lastName;
    private String doctorName;
    public int visitDay;
    int visitMonth;
    int visitYear;
    private BST<MedicalStaff> careTeam;

    /*
    // Summary: Initializes a Patient object with specific attributes
    // like personal details, visit date, and an assigned doctor.
    // Precondition: firstName, lastName, and doctorName are Strings;
    // visitDay, visitMonth, and visitYear are integers.
    // Postcondition: Creates a Patient instance and sets up an empty care team.
    */
    public Patient(String firstName, String lastName, String doctorName, int visitDay, int visitMonth, int visitYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.doctorName = doctorName;
        this.visitDay = visitDay;
        this.visitMonth = visitMonth;
        this.visitYear = visitYear;
        this.careTeam = new BST<>();
    }

    /*
    // Summary: Combines the first and last names of the patient into a single string.
    // Precondition: None
    // Postcondition: Returns a string representing the patient's full name.
    */
    public String getName() {
        return firstName + " " + lastName;
    }

    /*
    // Summary: Retrieves the name of the doctor responsible for this patient.
    // Precondition: None
    // Postcondition: Returns the name of the doctor as a String.
    */
    public String getDoctorName() {
        return doctorName;
    }

    /*
    // Summary: Gets the visit year of the patient.
    // Precondition: None
    // Postcondition: Returns the visit year as an integer.
    */
    public int getVisitYear() {
        return visitYear;
    }

    /*
    // Summary: Adds a new medical staff member to the patient's care team.
    // Precondition: staff is a valid MedicalStaff object.
    // Postcondition: The medical staff member is added to the care team.
    */
    public void addMedicalStaff(MedicalStaff staff) {
        careTeam.insert(staff);
    }

    /*
    // Summary:  Removes a specific medical staff member from the care team.
    // Precondition:name is a string formatted as "FirstName LastName".
    // Postcondition: Deletes the specified staff member from the care team if they exist.
    */
    public void removeMedicalStaff(String name) {
        careTeam.delete(new MedicalStaff(name.split(" ")[0], name.split(" ")[1], ""));
    }

    /*
    // Summary: Gets the list of medical staff members in the patient's care team.
    // Precondition: None
    // Postcondition: Returns a sorted list of MedicalStaff objects.
    */
    public List<MedicalStaff> getCareTeam() {
        return careTeam.inOrderTraversal();
    }

    /*
    // Summary: Compares two Patient objects based on their visit year and name.
    // Precondition: other is a Patient object.
    // Postcondition: Provides a comparison result for ordering purposes.
    */
    @Override
    public int compareTo(Patient other) {
        if (this.visitYear != other.visitYear) {
            return Integer.compare(this.visitYear, other.visitYear);
        } else {
            return this.getName().compareTo(other.getName());
        }
    }

    /*
    // Summary: Returns a string representation of the Patient object.
    // Precondition: None
    // Postcondition:Returns a string in the format "FirstName LastName, VisitYear, DoctorName".
    */
    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + visitYear + ", " + doctorName;
    }

    /*
    // Summary: Returns detailed information about the patient.
    // Precondition: None
    // Postcondition: Returns a string with detailed information about
    // the patient including their name, visit date, doctor name, and
    // care team members.
    */
    public String detailedInfo() {
        StringBuilder info = new StringBuilder();
        info.append(firstName).append(" ").append(lastName).append("\n");
        info.append(visitDay).append("/").append(visitMonth).append("/").append(visitYear).append("\n");
        info.append(doctorName).append("\n");
        for (MedicalStaff staff : getCareTeam()) {
            info.append(staff.toString()).append("\n");
        }
        return info.toString();
    }

    /*
    // Summary: Gets the visit day of the patient.
    // Precondition: None
    // Postcondition: Returns the visit day as an integer.
    */
    public int getVisitDay() {
        return visitDay;
    }

}