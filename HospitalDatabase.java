//-----------------------------------------------------
//Title: HospitalDatabase Class
//Author:  Ege Ottan
////ID: 10168090218
//Section: 02
//Assignment: 3
//Description: This class represents a hospital database that manages patients and their associated medical staff.
//-----------------------------------------------------
import java.util.ArrayList;
import java.util.List;

class HospitalDatabase {
    private BST<Patient> patientsByYear;

    /*
    // Summary: Initializes a new HospitalDatabase instance with an empty
    // binary search tree for managing patients.
    // Precondition: None
    // Postcondition: A new instance of HospitalDatabase is ready for use.
    */
    public HospitalDatabase() {
        patientsByYear = new BST<>();
    }

    /*
    // Summary: Adds a new patient to the database.
    // Precondition: patientName and doctorName must be valid Strings,
    // visitDay, visitMonth, and visitYear must be integers.
    // Postcondition: Inserts a new patient if their name is unique;
    // otherwise, updates the existing record.
    */
    public void addPatient(String patientName, String doctorName, int visitDay, int visitMonth, int visitYear) {
        String[] nameParts = patientName.split(" ");
        if (findPatientByName(patientName) != null) {
            System.out.println("ERROR: Patient " + patientName + " overwritten");
        } else {
            Patient newPatient = new Patient(nameParts[0], nameParts[1], doctorName, visitDay, visitMonth, visitYear);
            patientsByYear.insert(newPatient);
            System.out.println("INFO: Patient " + patientName + " has been added");
        }
    }

    /*
    // Summary: Removes a patient from the database.
    // Precondition: patientName is a String.
    // Postcondition: The patient is removed if found;
    // otherwise, an error message is printed.
    */
    public void removePatient(String patientName) {
        for (Patient patient : patientsByYear.inOrderTraversal()) {
            if (patient.getName().equals(patientName)) {
                patientsByYear.delete(patient);
                System.out.println("INFO: Patient " + patientName + " has been removed");
                return;
            }
        }
        System.out.println("ERROR: Patient " + patientName + " does not exist");
    }

    /*
    // Summary: Adds a medical staff member to a patient.
    // Precondition: patientName, memberName, memberRole are Strings.
    // Postcondition: The medical staff member is added to the
    // patient if found; otherwise, an error message is printed.
    */
    public void addMember(String patientName, String memberName, String memberRole) {
        for (Patient patient : patientsByYear.inOrderTraversal()) {
            if (patient.getName().equals(patientName)) {
                String[] nameParts = memberName.split(" ");
                MedicalStaff newMember = new MedicalStaff(nameParts[0], nameParts[1], memberRole);
                patient.addMedicalStaff(newMember);
                System.out.println("INFO: " + memberName + " has been added to the patient " + patientName);
                return;
            }
        }
        System.out.println("ERROR: Patient " + patientName + " does not exist");
    }

    /*
    // Summary: Removes a medical staff member from a patient.
    // Precondition: patientName, memberName are Strings.
    // Postcondition: The medical staff member is removed from
    // the patient if found; otherwise, an error message is printed.
    */
    public void removeMember(String patientName, String memberName) {
        for (Patient patient : patientsByYear.inOrderTraversal()) {
            if (patient.getName().equals(patientName)) {
                patient.removeMedicalStaff(memberName);
                System.out.println("INFO: " + memberName + " has been removed from the patient " + patientName);
                return;
            }
        }
        System.out.println("ERROR: Patient " + patientName + " does not exist");
    }

    /*
    // Summary: Displays all patients stored in the database.
    // Precondition: None
    // Postcondition: Prints the list of patients or "---none---" if the database is empty.
    */
    public void showAllPatients() {
        List<Patient> patients = patientsByYear.inOrderTraversal();
        if (patients.isEmpty()) {
            System.out.println("---none---");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    /*
    // Summary: Displays detailed information about a specific patient.
    // Precondition: patientName must be a valid String.
    // Postcondition: Prints the patient’s details or "---none---" if not found.
    */
    public void showPatient(String patientName) {
        for (Patient patient : patientsByYear.inOrderTraversal()) {
            if (patient.getName().equals(patientName)) {
                System.out.println(patient.detailedInfo());
                return;
            }
        }
        System.out.println("---none---");
    }

    /*
    // Summary: Displays all patients of a specific doctor.
    // Precondition: doctorName is a String.
    // Postcondition: All patients of the doctor are printed in
    // descending order by visit date; if no patients are found,
    // "---none---" is printed.
    */
    public void showDoctorPatients(String doctorName) {
        List<Patient> doctorPatients = new ArrayList<>();
        for (Patient patient : patientsByYear.inOrderTraversal()) {
            if (patient.getDoctorName().equals(doctorName)) {
                doctorPatients.add(patient);
            }
        }
        if (doctorPatients.isEmpty()) {
            System.out.println(doctorName + "\n---none---");
        } else {
            System.out.println(doctorName);
            doctorPatients.stream()
                    .sorted((p1, p2) -> Integer.compare(p2.getVisitYear(), p1.getVisitYear()))
                    .forEach(patient -> System.out.println(patient.getName() + ", " +
                            patient.visitDay + "/" + patient.visitMonth + "/" + patient.visitYear));
        }
    }

    /*
    // Summary: Displays all patients who visited in a specific year.
    // Precondition: visitYear is an integer.
    // Postcondition: All patients who visited in the given year
    // are printed; if no patients are found, "---none---" is printed.
    */
    public void showPatients(int visitYear) {
        List<Patient> patientsOfYear = new ArrayList<>();
        for (Patient patient : patientsByYear.inOrderTraversal()) {
            if (patient.getVisitYear() == visitYear) {
                patientsOfYear.add(patient);
            }
        }
        if (patientsOfYear.isEmpty()) {
            System.out.println(visitYear + "\n---none---");
        } else {
            patientsOfYear.sort((p1, p2) -> {
                if (p1.getName().equals(p2.getName())) {
                    // If names are equal, sort by visit date in descending order
                    return Integer.compare(p2.getVisitDay() * 100 + p2.getVisitDay(),
                            p1.getVisitDay() * 100 + p1.getVisitDay());
                } else {
                    // Sort by names in descending alphabetical order
                    return p2.getName().compareTo(p1.getName());
                }
            });
            System.out.println(visitYear);
            for (Patient patient : patientsOfYear) {
                System.out.println(patient.getName() + ", " +
                        patient.visitDay + "/" + patient.visitMonth);
            }
        }
    }

    /*
    // Summary: Finds and returns a patient by name.
    // Precondition: patientName is a String.
    // Postcondition: Returns the patient if found; otherwise,
    // returns null.
    */
    private Patient findPatientByName(String patientName) {
        for (Patient patient : patientsByYear.inOrderTraversal()) {
            if (patient.getName().equals(patientName)) {
                return patient;
            }
        }
        return null;
    }
}

