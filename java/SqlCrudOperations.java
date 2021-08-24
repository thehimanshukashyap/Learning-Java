package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class SqlCrudOperations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHandler dbHandler = new DatabaseHandler(this);

        Log.d(" ", "---------- INSERT ----------");
        dbHandler.addContact(new Contacts(1, "Ravi", "someone@example.com"));
        dbHandler.addContact(new Contacts(2, "Srinivas", "someone@example.com"));
        dbHandler.addContact(new Contacts(3, "Tommy", "someone@example.com"));
        dbHandler.addContact(new Contacts(4, "Karthik", "someone@example.com"));

        Log.d(" ", "---------- READ ALL ----------");
        List<Contacts> contacts = dbHandler.getAllContacts();
        for (Contacts cn : contacts) {
            String log = "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getEmail();
            Log.d("Contact:  ", log);
        }

        Log.d(" ", "---------- READ ----------");
        Contacts fetchContact = dbHandler.getContact(2);
        String log = "Id: " + fetchContact.getId() + " ,Name: " + fetchContact.getName() + " ,Phone: " +
                fetchContact.getEmail();
        Log.d("Contact:  ", log);

        Log.d(" ", "---------- UPDATE ----------");
        int rows = dbHandler.updateContact(new Contacts(3, "John", "someone@example.com"));

        Log.d(" ", "---------- DELETE ----------");
        dbHandler.deleteContact(new Contacts(4, "Karthik", "someone@example.com"));
    }
}