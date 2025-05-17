package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;

    }

    public MobilePhone(String myNumber, List<Contact> initialContact) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(initialContact);
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }
    public boolean addNewContact(Contact contact){
        if(myContacts.equals(contact)){
            return false;
        }
        myContacts.add(contact);
        return  true;
    }
    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundIndex = myContacts.indexOf(oldContact);
        if(foundIndex < 0){
            return false;
        }
        if(!oldContact.getName().equals(newContact.getName()) && myContacts.contains((newContact))){
            return false;
        }
        myContacts.set(foundIndex, newContact);
        return true;
    }
    public boolean removeContact(Contact contact){
        if(myContacts.contains((contact)) && myContacts.remove(contact)){
            return true;
        }
        return false;
    }

    public int findContact(String contactName){
        for(int i = 0; i < myContacts.size(); i++){
            if(myContacts.get(i).getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }
    public int findContact(Contact contact){
        return findContact(contact.getName());
    }
    public Contact queryContact(String name){
        int index = findContact(name);
        if(index >= 0){
            return myContacts.get(index);
        }
        return null;
    }
    public void printContact(){
        for(Contact contact : myContacts){
            System.out.println("Name: " + contact.getName() +  " Phone Number: " + contact.getPhoneNumber());
        }
    }
}
