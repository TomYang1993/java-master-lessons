package yxy.tom.mobilephone.arraylist;

import java.util.Scanner;

public class ArrayListChallenge {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone phone = new MobilePhone("some number");

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice: " );
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    phone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchForContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a contact to the list.");
        System.out.println("\t 3 - To modify a contact in the list.");
        System.out.println("\t 4 - To remove a contact from the list.");
        System.out.println("\t 5 - To search for a contact in the list.");
        System.out.println("\t 6 - To quit the phone.");
    }

    public static void addContact() {
        System.out.print("Please enter the contact name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter the contact cell phone: ");
        String number = scanner.nextLine();
        Contact newContact = new Contact(name, number);
        if(phone.addContact(newContact)){
            System.out.println("new contact added, name: " + name + " number: " + number);
        }else{
            System.out.println("adding contact failed1");
        }
    }

    public static void modifyContact() {
        System.out.print("Enter contact name: ");
        String  name = scanner.nextLine();
        Contact originalContact = phone.queryContact(name);
        System.out.print("Enter replacement name: ");
        String  newName = scanner.nextLine();
        System.out.print("Enter replacement phone number: ");
        String  newNumber = scanner.nextLine();
        Contact newContact = new Contact(newName, newNumber);
        if(phone.modifyContact(originalContact, newContact)){
            System.out.println("contact updated, name: " + newContact.getName() + " number: " + newContact.getPhoneNumber());
        }else{
            System.out.println("editing contact failed");
        }

    }

    public static void removeContact() {
        System.out.print("Enter contact name: ");
        String  name = scanner.nextLine();
        Contact originalContact = phone.queryContact(name);
        phone.removeContact(originalContact);
    }

    public static void searchForContact() {
        System.out.print("Enter contact name: ");
        String  name = scanner.nextLine();
        Contact con = phone.queryContact(name);
        System.out.println("The result retuns back with name: " + con.getName() + ", phone number: " +con.getPhoneNumber() );
    }
}
