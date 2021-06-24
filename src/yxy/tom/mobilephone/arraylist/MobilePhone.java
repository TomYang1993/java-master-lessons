package yxy.tom.mobilephone.arraylist;

import yxy.tom.mobilephone.arraylist.Contact;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contacts;
    private String myNumber;

    public MobilePhone(String myNumber) {
        this.contacts = new ArrayList<Contact>();
        this.myNumber = myNumber;
    }

    public void quit() {
        System.out.println("the phone has been shut down.");
    }

    public boolean addContact(Contact newContact) {
        int index = searchContact(newContact);
        if(index >= 0){
            return false;
        }
        contacts.add(newContact);
        return true;
    }

    public boolean removeContact(Contact removeContact) {
        int index = searchContact(removeContact);
        if( index >= 0){
            contacts.remove(index);
            return true;
        }else{
            return false;
        }
    }

    public boolean modifyContact(Contact originalContact, Contact modifyContact) {
        int index = searchContact(originalContact);
        if(index >= 0){
            contacts.set(index, modifyContact);
            return true;
        }else{
            System.out.println("no such contact existed.");
            return false;
        }
    }

    public void printContacts() {
        System.out.println("CONTACT LIST:");
        for(int i = 0; i < contacts.size(); i++){
            System.out.println("Name: " + contacts.get(i).getName() + ", phone number: " + contacts.get(i).getPhoneNumber());
        }
    }

    private int searchContact(Contact contact) {
        return contacts.indexOf(contact);
    }

    private int searchContact(String name) {
        for(int i = 0; i < contacts.size(); i++){
            if(name.equals(contacts.get(i).getName())){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = searchContact(name);
        if(position >= 0){
            return contacts.get(position);
        }else{
            System.out.println("the contacts you queried is not here.");
            return null;
        }
    }

}
