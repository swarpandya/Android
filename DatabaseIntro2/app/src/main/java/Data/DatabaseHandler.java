package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Model.Contact;
import Utils.Util;

/**
 * Created by Swar on 11-12-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL = Structured Query Language
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + "INTEGER PRIMARY KEY," + Util.KEY_NAME + " TEXT,"
                + Util.KEY_PHONE_NUMBER + " TEXT" + ");";

        //Execute SQL
        db.execSQL(CREATE_CONTACT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME);

        //CREATE TABLE AGAIN
        onCreate(db);
    }

    /*
    CRUD Operations - Create , Read , Update , Delete
     */

    //Add Contact
    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(Util.KEY_NAME , contact.getName());
        value.put(Util.KEY_PHONE_NUMBER , contact.getPhoneNumber());

        //Insert to row
        db.insert(Util.TABLE_NAME , null , value);
        db.close(); //close db connection
    }

    //Get a single Contact
    public Contact getContact(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.TABLE_NAME , new String[] { Util.KEY_ID,
                Util.KEY_NAME , Util.KEY_PHONE_NUMBER} , Util.KEY_ID + "=?" ,
                new String[]{String.valueOf(id)} , null ,null ,null ,null);

        if(cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1) , cursor.getString(2));

        return contact;
    }

    //Get all Contacts

    public List<Contact> getAllContacts(){

        SQLiteDatabase db = this.getReadableDatabase();
        List<Contact> contactList = new ArrayList<>();

        //Select all Contacts

        String selectAll = "SELECT * FROM" +Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll,null);

        //Loop through our Contacts

        if(cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));

                //Add contact object to our contact list
                contactList.add(contact);

            }while(cursor.moveToNext());
        }
        return contactList;
    }

    //Update Contact
    public int updateContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME,contact.getName());
        values.put(Util.KEY_PHONE_NUMBER,contact.getPhoneNumber());

        //Update Row
        return db.update(Util.TABLE_NAME,values,Util.KEY_ID +"=?",
                new String[]{String.valueOf(contact.getId())});
    }

    //Delete single Contact
    public void deleteContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME,Util.KEY_ID+"=?",
                new String[]{String.valueOf(contact.getId())});

        db.close();

    }

    //Get Contacts Count
    public int getContactsCount(){
        String countQuery = "SELECT * FROM " +Util.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        //cursor.close();
        return cursor.getCount();
    }
}
