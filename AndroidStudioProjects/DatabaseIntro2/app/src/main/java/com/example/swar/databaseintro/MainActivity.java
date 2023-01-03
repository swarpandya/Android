package com.example.swar.databaseintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Model.Contact;
import Utils.Util;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("DB Count: ",String.valueOf(db.getContactsCount()));

        //Insert contacts
        Log.d("Insert: ","Inserting...");
        db.addContact(new Contact("Swar","8734871861"));
        db.addContact(new Contact("Sagar","9825582985"));
        db.addContact(new Contact("Chintan","9409032529"));
        db.addContact(new Contact("Dhrumil","8469988788"));

        //Read the contacts
        Log.d("Reading..." , "Reading all contacts");
        List<Contact> contactList = db.getAllContacts();

        //Get single contact
        Contact singleContact = db.getContact(1);
        singleContact.setName("Swaruuu");
        singleContact.setPhoneNumber("8200975760");

        //Updated contact
        //int newContact = db.updateContact(singleContact);

        //Log.d("Single Contact: ", "Updated Row"+String.valueOf(newContact)+"Name: "+singleContact.getName()+"Phone: "+singleContact.getPhoneNumber());

        //db.deleteContact(singleContact);

        for(Contact c : contactList){

            String log = "ID: "+c.getId()+",Name: "+c.getName()+",Phone: "+c.getPhoneNumber();
            Log.d("Name: ", log);
        }
    }
}
