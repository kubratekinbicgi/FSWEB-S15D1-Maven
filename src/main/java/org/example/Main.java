package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;
import org.example.models.Grocery;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grocery grocery = new Grocery();
            grocery.startGrocery();

        List<Contact> initialContact = new ArrayList<>();
        initialContact.add(new Contact("Bob", "31415926"));
        initialContact.add(new Contact("Alice" , "16180339"));
        initialContact.add(new Contact("Tom", "11235813"));

        MobilePhone mobilePhone = new MobilePhone("5550000", initialContact);
        mobilePhone.addNewContact(new Contact("Test", "999999999"));
        Contact test = new Contact("Test", "999999999");

        Contact updatedTest = new Contact("Test", "000000000");

        mobilePhone.updateContact(test, updatedTest);
        mobilePhone.removeContact(updatedTest);
        mobilePhone.printContact();

        int index = mobilePhone.findContact("Tom");

        if (index >= 0) {
            System.out.println("Tom listede, sırası: " + index);
        } else {
            System.out.println("Tom bulunamadı.");
        }
    }
}
