package com.project3.www.AutismAtEase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Madhav on 3/6/2018.
 */


public class ContactDataSource {

    private SQLiteDatabase database;
    private ContactDBHelper dbHelper;

    public ContactDataSource(Context context) {
        dbHelper = new ContactDBHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertContact(Contact c) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("fname", c.getfName());
            initialValues.put("lname", c.getlName());
            initialValues.put("gender", c.getGender());
            initialValues.put("age", c.getAge());
            initialValues.put("email", c.getEMail());
            initialValues.put("password", c.getPassword());

            didSucceed = database.insert("contact", null, initialValues) > 0;
        } catch (Exception e) {
            //Do nothing -will return false if there is an exception
        }
        return didSucceed;
    }

    public boolean updateContact(Contact c) {
        boolean didSucceed = false;
        try {
            Long rowId = (long) c.getContactID();
            ContentValues updateValues = new ContentValues();


            updateValues.put("fname", c.getfName());
            updateValues.put("lname", c.getlName());
            updateValues.put("gender", c.getGender());
            updateValues.put("age", c.getAge());
            updateValues.put("email", c.getEMail());
            updateValues.put("password", c.getPassword());

            didSucceed = database.update("contact", updateValues, "_id=" + rowId, null) > 0;
        } catch (Exception e) {
            //Do nothing -will return false if there is an exception
        }
        return didSucceed;
    }

    public int getLastContactId() {
        int lastId = -1;
        try {
            String query = "Select MAX(_id) from contact";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            lastId = cursor.getInt(0);
            cursor.close();
        } catch (Exception e) {
            lastId = -1;
        }
        return lastId;
    }

    public Cursor getData() {

        return database.rawQuery("Select * FROM contact", null);
    }

}

