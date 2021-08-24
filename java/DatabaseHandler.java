package com.example.learnandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int databaseVersion = 1;
    private static final String databaseName = "tutorial";

    private static final String tableName = "contacts";
    private static final String kId = "id";
    private static final String kName = "name";
    private static final String kEmail = "email";

    DatabaseHandler(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE =
                "CREATE TABLE " + tableName + "(" +
                    kId + " INTEGER PRIMARY KEY," +
                    kName + " VARCHAR2(20)," +
                    kEmail + " VARCHAR2(50)" +
                ")";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "DROP TABLE IF EXISTS " + tableName;
        onCreate(db);
    }

    public void addContact(Contacts contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(kId, contact.getId());
        values.put(kName, contact.getName());
        values.put(kEmail, contact.getEmail());

        Log.d("Database: ", "Inserting record...");
        db.insert(tableName, null, values);
        Log.d("Database: ", "Record Inserted");
        db.close();
    }

    public Contacts getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Log.d("Database: ", "Fetching record...");
        Cursor cursor = db.query(
                tableName,
                new String[] {kId, kName, kEmail},
                kId + "=?",
                new String[] {String.valueOf(id)},
                null,
                null,
                null,
                null
        );
        db.close();
        if(cursor != null) {
            cursor.moveToFirst();
            Log.d("Database: ", "Record Fetched.");
            return new Contacts(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2)
            );
        }
        return null;
    }

    public List<Contacts> getAllContacts() {
        SQLiteDatabase db = this.getReadableDatabase();

        Log.d("Database: ", "Fetching records...");
        String query = "SELECT * FROM "+ tableName;
        Cursor cursor = db.rawQuery(query, null);
        Log.d("Database: ", "Records Fetched.");
        db.close();

        List<Contacts> list = new ArrayList<Contacts>();
        while(cursor.moveToNext()) {
            list.add(new Contacts(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2)
            ));
        }

        return list;
    }

    public int updateContact(Contacts contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(kName, contact.getName());
        values.put(kEmail, contact.getEmail());

        Log.d("Database: ", "Updating record...");
        int rowsAffected =  db.update(
                tableName,
                values,
                kId + "=?",
                new String[] {String.valueOf(contact.getId())}
        );
        Log.d("Database: ", "Record Updated.");
        db.close();
        return rowsAffected;
    }

    public void deleteContact(Contacts contact) {
        SQLiteDatabase db = getWritableDatabase();

        Log.d("Database: ", "Deleting record...");
        db.delete(
                tableName,
                kId +"=?",
                new String[] {String.valueOf(contact.getId())}
        );
        Log.d("Database: ", "Record Deleted.");
        db.close();
    }
}
