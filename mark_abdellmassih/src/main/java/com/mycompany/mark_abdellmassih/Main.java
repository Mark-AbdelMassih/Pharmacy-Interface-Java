
package com.mycompany.mark_abdellmassih;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
      public static void main(String[] args) {

        Pharmacy pharmacy = new Pharmacy("myPharma");
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to \" myPharma \" pharmacy system.");
        System.out.println("-----------------------------------------------");
        do {
            choice = menu(input);

            switch (choice) {
case 1:
    System.out.println("Enter the information of the new medicine:");
    System.out.print("Choose O or o for over the counter medicine and p or P for prescription medicine:");
    String medicineType = input.next();
    System.out.println();
    System.out.print("name: ");
    String name = input.next();
    System.out.println();
    System.out.print("composition: ");
    String composition = input.next();
    System.out.println();
    System.out.print("dose: ");
    int dose = input.nextInt();
    System.out.println();
    System.out.print("quantity: ");
    int quantity = input.nextInt();
    System.out.println();
    System.out.print("price: ");
    double price = input.nextDouble();
    System.out.println();
    Medicine medicine;
    if (medicineType.equalsIgnoreCase("o")) {
        System.out.print("Enter the minimum Age for this medicine: ");
        int minAge = input.nextInt();
        System.out.println();
        medicine = new OverTheCounter(name, composition, dose, quantity, price, minAge);
    } else if (medicineType.equalsIgnoreCase("p")) {
        System.out.print("Enter the doctor specialization for this medicine: ");
        String doctorSpecialization = input.next();
        System.out.println();
        medicine = new Prescription(name, composition, dose, quantity, price, doctorSpecialization);
    } else {
        System.out.println("Invalid medicine type.");
        break;
    }
    pharmacy.addMedicine(medicine);
    System.out.println("New medicine is added successfully");
    System.out.println("-----------------------------------------------");
    break;
                case 2:
                    System.out.println("Enter the name of the medicine to be found");
                    String nameToBeFound = input.nextLine();

                    int[] foundIndices = pharmacy.searchByName(nameToBeFound);
                    if (foundIndices != null) {
                        System.out.println(foundIndices.length + " medicine found matching this name.");
                        for (int index : foundIndices) {
                            Medicine[] medicines = pharmacy.getMedicines();
                            Medicine med = medicines[index];
                            System.out.println((index+1) + "- " + med.toString());
                        }
                    } else {
                        System.out.println("Medicine not found.");
                    }
                    System.out.println("-----------------------------------------------");
                    break;
                case 3:
                    System.out.println("Enter the composition to be found:");
                    String compositionToBeFound = input.nextLine();

                    int[] foundIndices2 = pharmacy.searchByComposition(compositionToBeFound);
                    if (foundIndices2.length > 0) {
                        System.out.println(foundIndices2.length + " medicine found matching this composition.");
                        for (int index : foundIndices2) {
                            Medicine[] medicines = pharmacy.getMedicines();
                            Medicine med = medicines[index];
                            System.out.println((index+1) + "- " + med.toString());
                        }
                    } else {
                        System.out.println("No medicines found.");
                    }
                    System.out.println("-----------------------------------------------");
                    break;
                case 4:
                    System.out.print("Enter the name of the medicine: ");
                    String medicinetosell = input.nextLine();
                    System.out.println();
                    System.out.print("Enter the dose: ");
                    int dosetoresell = input.nextInt();
                    System.out.println();
                    System.out.print("Enter the quantity: ");
                    int quantitytosell = input.nextInt();
                    System.out.println();
                    if(pharmacy.sellMedicine(medicinetosell, dosetoresell, quantitytosell)) {
                        System.out.println();
                    }
                    else {
                        System.out.println("Selling unsuccessful.");
                    }
                    System.out.println("-----------------------------------------------");
                    break;
                case 5:
                    System.out.print("Enter the name of the medicine: ");
                    String medicineToRestock = input.nextLine();
                    System.out.println();
                    System.out.print("Enter the dose: ");
                    int doseToRestock = input.nextInt();
                    System.out.println();
                    System.out.print("Enter the quantity: ");
                    int quantityToRestock = input.nextInt();
                    System.out.println();
                    if(pharmacy.restock(medicineToRestock, doseToRestock, quantityToRestock)) {
                        System.out.println("Restock Successful");
                    }
                    else {
                        System.out.println("Restock Unsuccessful");
                    }
                    System.out.println("-----------------------------------------------");
                    break;
                case 6:
                    Medicine[] medicines = pharmacy.getMedicines();
                    if (medicines.length > 0) {
                        for (int i=0; i<pharmacy.getNumberOfMedicines();i++) {
                            if (medicines != null) {
                                    System.out.println("Medicine " + (i+1) + " : " + medicines[i].toString());
                            }
                            System.out.println("----");
                        }
                    } else {
                        System.out.println("No medicines in the pharmacy.");
                    }
                    System.out.println("-----------------------------------------------");
                    break;

                case 7:
                    System.out.println(pharmacy.toString());
                    System.out.println("-----------------------------------------------");
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        } while (choice != 8);

        input.close();
    }

    public static int menu(Scanner input) {
        System.out.println("-------------------------------------------");
        System.out.println("Choose one the following options:");
        System.out.println("1- Add a new medicine");
        System.out.println("2- Search for a medicine by name");
        System.out.println("3- Search for a medicine by composition");
        System.out.println("4- Sell a medicine");
        System.out.println("5- Restock a medicine");
        System.out.println("6- Display all medicines");
        System.out.println("7- Display information");
        System.out.println("8- Exit");
        System.out.print("Enter your choice (between 1 and 8): ");
        int choice = input.nextInt();
        input.nextLine();
        System.out.println();
        return choice;
    }

}  

