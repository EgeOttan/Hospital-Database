//--------------------------------------------------------
//Title: main Class
//Author: Ege Ottan
////ID: 10168090218
//Section: 02
//Assignment: 3
//Description:This class contains the main method to test the functionality of the HospitalDatabase class.
//--------------------------------------------------------
public class main {

    /*
    // Summary: The main method executes a series of operations
    // on a HospitalDatabase object to demonstrate its capabilities.
    // Precondition: None
    // Postcondition:Outputs the results of different operations
    // performed on the HospitalDatabase to the console.
    */
    public static void main(String[] args) {
        HospitalDatabase hd = new HospitalDatabase();

        System.out.println("---none---");
        System.out.println(" ");

        // Adding patients to the hospital database
        hd.addPatient("Michael Johnson", "Emma Thompson", 19, 12, 2022);
        hd.addPatient("Ethan Lee", "Olivia Sanchez", 8, 9, 2020);
        hd.addPatient("Noah Miller", "Olivia Sanchez", 27, 2, 2019);
        hd.addPatient("Liam Davis", "Isabella Martinez", 3, 4, 2022);
        hd.addPatient("Ava Taylor", "Isabella Martinez", 15, 5, 2024);
        hd.addPatient("Mason Moore", "William Anderson", 7, 6, 2021);
        hd.addPatient("Charlotte Garcia", "Lucas Lewis", 30, 10, 2023);
        // Attempting to add a duplicate patient
        hd.addPatient("Noah Miller", "Olivia Sanchez", 27, 2, 2019);

        System.out.println(" ");

        // Displaying all patients
        hd.showAllPatients();

        System.out.println(" ");

        // Removing a patient from the hospital database
        hd.removePatient("Ava Taylor");
        System.out.println(" ");
        // Displaying all patients after removal
        hd.showAllPatients();

        System.out.println(" ");

        // Displaying detailed information of a specific patient
        hd.showPatient("Michael Johnson");

        System.out.println(" ");

        // Adding medical staff members to the care teams of various patients
        hd.addMember("Mason Moore", "Daniel Roberts", "Nurse");
        hd.addMember("Mason Moore", "Victoria Stewart", "Radiologist");
        hd.addMember("Mason Moore", "Tyler Campbell", "Medical Assistant");
        hd.addMember("Mason Moore", "Hannah Martin", "Paramedic");
        hd.addMember("Michael Johnson", "Jack Allen", "Patient Care Technician");
        hd.addMember("Michael Johnson", "Oliver Nelson", "Anesthesiologist");
        hd.addMember("Michael Johnson", "Sophia Rivera", "Pathologist");
        hd.addMember("Michael Johnson", "Evan Hall", "Laboratory Technician");
        hd.addMember("Michael Johnson", "Megan Price", "Nurse");

        // Attempting to add staff to a non-existent patient, expecting an error
        hd.addMember("Ava Taylor", "Brianna Reed", "Dietitian"); // This should show an error
        // Adding staff to another patient's care team
        hd.addMember("Charlotte Garcia", "Oliver Nelson", "Anesthesiologist");
        hd.addMember("Charlotte Garcia", "Trevor Jenkins", "Medical Equipment Technician");
        hd.addMember("Charlotte Garcia", "Justin Flores", "Speech-Language Pathologist");

        System.out.println(" ");

        // Viewing detailed information for specific patients
        hd.showPatient("Mason Moore");
        System.out.println(" ");
        hd.showPatient("Michael Johnson");

        System.out.println(" ");
        // Removing a medical staff member from a patient's care team
        hd.removeMember("Michael Johnson", "Evan Hall");
        System.out.println(" ");
        // Viewing the updated care team for a patient
        hd.showPatient("Michael Johnson");

        System.out.println(" ");
        // Displaying patients under the care of a specific doctor
        hd.showDoctorPatients("Olivia Sanchez");
        System.out.println(" ");
        hd.showDoctorPatients("Emma Thompson");

        System.out.println(" ");
        // Querying patients based on their visit year
        hd.showPatients(2022);

        System.exit(0);
    }
}
