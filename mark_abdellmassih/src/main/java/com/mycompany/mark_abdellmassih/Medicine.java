
package com.mycompany.mark_abdellmassih;


public class Medicine {

    /** data fields for the Medicine class */
    private String name;
    private String composition;
    private int dose;
    private double price;
    private int quantity;

    /** With-arg constructor that takes name, composition, and dose and sets other fields to default values */
    public Medicine(String name, String composition, int dose) {
        this.name = name.toLowerCase();
        this.composition = composition.toLowerCase();
        this.dose = dose;
        this.price = 10.0;
        this.quantity = 0;
    }

    /** With-arg constructor that takes name, composition, dose, quantity, and price */
    public Medicine(String name, String composition, int dose, int quantity, double price) {
        this.name = name.toLowerCase();
        this.composition = composition.toLowerCase();
        this.dose = dose;
        this.price = price;
        this.quantity = quantity;
    }

    /** Getters and setters for all fields */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition.toLowerCase();
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /** ToString method that returns the description of the medicine */
    public String toString() {
        return "     name: " + name + "\n     composition: " + composition + "\n     dose: " + dose + "mg" 
                + "\n     price: " + price + "\n     quantity: " + quantity;
    }

    /** equals() method that compares the medicine object to another object */
    public boolean equals(Object obj) {
        if (obj instanceof Medicine) {
            Medicine other = (Medicine) obj;
            return this.name.equals(other.getName()) && this.dose == other.getDose();
        }
        return false;
    }
}

