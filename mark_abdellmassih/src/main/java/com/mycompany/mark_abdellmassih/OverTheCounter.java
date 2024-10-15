
package com.mycompany.mark_abdellmassih;

/** OverTheCounter - child class and a specific type of Medicines ( Over the counter Medicines) */
public class OverTheCounter extends Medicine {

       /** the added minAge data field of the OverTheCounter class */
    private int minAge;

    /** With-arg constructor that takes name, composition, dose, and minAge and sets other fields to default values */
    public OverTheCounter(String name, String composition, int dose, int minAge) {
        super(name, composition, dose);
        this.minAge = minAge;
    }

    /** With-arg constructor that takes name, composition, dose, quantity, price, and minAge of the medicine and sets the code to its corresponding value. */
    public OverTheCounter(String name, String composition, int dose, int quantity, double price, int minAge) {
        super(name, composition, dose, quantity, price);
        this.minAge = minAge;
    }

    /** Getter and setter for minAge */
    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    /** ToString method that returns the description of the medicine */
    public String toString() {
        return "Over the Counter :\n" + super.toString() + "\n     minimum Age: " + minAge;
    }
}