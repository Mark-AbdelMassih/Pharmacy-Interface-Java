
package com.mycompany.mark_abdellmassih;
import java.util.ArrayList;
import java.util.Arrays;
/** Pharmacy class - container of medicines */
public class Pharmacy {
    
    /** attributes of the Pharmacy class */
    private String name;
    private Medicine[] medicines;
    private int overTheCounterQuantity;
    private int prescriptionQuantity;
    private int numberOfMedicines;
    private static int MaxNumberOfMedicines = 100;

    /** With-arg constructor that will create a new pharmacy given with a given 
name and set all the other values to their default. */
    public Pharmacy(String name) {
        this.name = name;
        this.medicines = new Medicine[MaxNumberOfMedicines];
        this.overTheCounterQuantity = 0;
        this.prescriptionQuantity = 0;
        this.numberOfMedicines = 0;
    }
    
    /**  The addMedicine method that will accept a new medicine of any type and 
checks if the medicine already exists in the array of medicines or not. */
    public void addMedicine(Medicine medicine) {
        if (numberOfMedicines < MaxNumberOfMedicines) {
            int index = searchByNameAndDose(medicine.getName(), medicine.getDose());
            if (index == -1) {
                medicines[numberOfMedicines++] = medicine;
                if (medicine instanceof OverTheCounter) {
                    overTheCounterQuantity += medicine.getQuantity();
                } else if (medicine instanceof Prescription) {
                    prescriptionQuantity += medicine.getQuantity();
                }
            } else {
                System.out.println("The medicine already exists.");
            }
        } else {
            System.out.println("The medicine could not be added. The pharmacy is full.");
        }
    }
    
    /**  The raisePrises method that will raise the price of all the medicines by a 
specific percentage. If the percentage is negative the method will reduce the 
price by the specified percentage */
    public void raisePrices(double percentage) {
        for (int i = 0; i < numberOfMedicines; i++) {
            double newPrice = medicines[i].getPrice() * (1 + percentage / 100);
            medicines[i].setPrice(newPrice);
        }
    }

    
    /** The searchByName method that will search the array for all medicines 
having a given name (medicines with same name and different dose can be 
present in the array). The method returns an array of int representing the 
indices of those medicines in the array. */
    public int[] searchByName(String name) {
        int[] indices = new int[numberOfMedicines];
        int count = 0;
        for (int i = 0; i < numberOfMedicines; i++) {
            if (medicines[i].getName().equals(name)) {
                indices[count++] = i;
            }
        }
        
        return Arrays.copyOfRange(indices, 0, count);
    }
    
    
    /** The searchByNameAndDose method that will search the array for a specific 
medicine having a given name and dose. If found the method will return the 
index of this medicine in the array. Otherwise the method will return -1. */
    public int searchByNameAndDose(String name, int dose) {
        for (int i = 0; i < numberOfMedicines; i++) {
            if (medicines[i].getName().equals(name) && medicines[i].getDose() == dose) {
                return i;
            }
        }
        return -1;
    }

    /** The searchByComposition method that will search the array of medicines 
for all medicines having the specified composition. The method returns an 
array of int representing the indices of those medicines in the array. */
    public int[] searchByComposition(String composition) {
        int[] indices = new int[numberOfMedicines];
        int count = 0;
        for (int i = 0; i < numberOfMedicines; i++) {
            if (medicines[i].getComposition().equals(composition)) {
                indices[count++] = i;
            }
        }
       
        return Arrays.copyOfRange(indices, 0, count);
    }

    /** The sellMedicine method that will accept the name and dose of the 
medicine and the required quantity. The method will search for a medicine 
by its specified name and dose. */
    public boolean sellMedicine(String name, int dose, int quantity) {
        int index = searchByNameAndDose(name, dose);
        if (index != -1) {
            Medicine medicine = medicines[index];
            if (medicine.getQuantity() >= quantity) {
                medicine.setQuantity(medicine.getQuantity() - quantity);
                if (medicine instanceof OverTheCounter) {
                    overTheCounterQuantity -= quantity;
                } else if (medicine instanceof Prescription) {
                    prescriptionQuantity -= quantity;
                }
                System.out.println("Selling successful.");
                return true;
            } else {
                System.out.println("Available quantity is not enough.");
                return false;
            }
        } else {
            System.out.println("The medicine is not found.");
            return false;
        }
    }

    /** The restock method that will accept the name and dose of a medicine and 
search the array of medicines to check if this medicine already exists or not */
    public boolean restock(String name, int dose, int quantity) {
    Medicine medicine = new Medicine(name,"", dose);
    int index = searchByNameAndDose(medicine.getName(), medicine.getDose());
    if (index == -1) {
        return false;
    } else {
        medicines[index].setQuantity(medicines[index].getQuantity() + quantity);
        if (medicines[index] instanceof Prescription) {
            prescriptionQuantity += quantity;
        } else {
            overTheCounterQuantity += quantity;
        }
        return true;
    }
}

/** Getters and Setters */

public Medicine[] getMedicines() {
    return medicines;
}

public int getPrescriptionQuantity() {
    return prescriptionQuantity;
}

public int getOverTheCounterQuantity() {
    return overTheCounterQuantity;
}

public int getNumberOfMedicines() {
    return numberOfMedicines;
}

public int getMaxNumberOfMedicines() {
    return MaxNumberOfMedicines;
}

public void setName(String name) {
    this.name = name;
}

public void setMaxNumberOfMedicines(int MaxNumberOfMedicines) {
    this.MaxNumberOfMedicines = MaxNumberOfMedicines;
}


/** toString method that will return information about the pharmacy */

@Override
public String toString() {
    return "Pharmacy: " + this.name + "\n" +
            "Number of Medicines: " + this.numberOfMedicines + "\n" +
            "Over the counter quantity: " + this.overTheCounterQuantity + "\n" +
            "Prescription quantity: " + this.prescriptionQuantity;
    }
}