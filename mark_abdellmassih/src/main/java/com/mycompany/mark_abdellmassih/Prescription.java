
package com.mycompany.mark_abdellmassih;


public class Prescription extends Medicine {

        /** the added doctorSpecialization data field of the Prescription class */
    private String doctorSpecialization;

    /** With-arg constructor that takes name, composition, dose, and doctorSpecialization and sets other fields to default values */
    public Prescription(String name, String composition, int dose, String doctorSpecialization) {
        super(name, composition, dose);
        this.doctorSpecialization = doctorSpecialization;
    }

    /** With-arg constructor that takes name, composition, dose, quantity, price, and doctorSpecialization */
    public Prescription(String name, String composition, int dose, int quantity, double price, String doctorSpecialization) {
        super(name, composition, dose, quantity, price);
        this.doctorSpecialization = doctorSpecialization;
    }

    /** Getter and setter for doctorSpecialization */
    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    /** ToString method that returns the description of the medicine */
    public String toString() {
        return "Prescription :\n" + super.toString() + "\n     doctor specialization: " + doctorSpecialization;
    }
}