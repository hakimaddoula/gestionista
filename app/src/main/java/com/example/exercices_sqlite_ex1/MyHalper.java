package com.example.exercices_sqlite_ex1;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyHalper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Gestion.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "UserGestion";
    private static final String COLUMN_FULLNAME = "F_Name";
    private static final String COLUMN_USERNAME = "U_Name";
    private static final String COLUMN_PASSWORD = "Password";

    public MyHalper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                " (" + COLUMN_FULLNAME + " TEXT PRIMARY KEY , " + COLUMN_USERNAME + " TEXT ," +
                COLUMN_PASSWORD + " TEXT " +
                 ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }


    public boolean AddUser(String FullName, String UserName, String  Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FULLNAME, FullName);
        contentValues.put(COLUMN_USERNAME, UserName);
        contentValues.put(COLUMN_PASSWORD, Password);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    /*public boolean UpdateUser(String name, String password, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();//l3mara
        contentValues.put(COLUMN_PASSWORD, password);
        contentValues.put(COLUMN_EMAIL, email);

        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where name=?", new String[]{name}); //ghayjiblna ster librina nmodifier fih
        if (cursor.getCount() > 0) {
            long result = db.update(TABLE_NAME, contentValues, "name =?", new String[]{name}); //bach kat modifier f la table
            if (result == -1) return false;
            else return true;
        } else return false;
    }

    public boolean DeleteUser(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where name=?", new String[]{name});

        if (cursor.getCount() > 0) {

            long result = db.delete(TABLE_NAME, "name =?", new String[]{name}); //bach kat Supprimer f la table
            if (result == -1)
                return false;

            else return true;

        } else return false;
    }*/

    public ArrayList<String> GetData()
    {
        ArrayList<String> ls=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from "+TABLE_NAME ,null);

        c.moveToFirst();
        while ( c.isAfterLast()==false){
            String FName=c.getString(c.getColumnIndexOrThrow(COLUMN_FULLNAME));
            String UName=c.getString(c.getColumnIndexOrThrow(COLUMN_USERNAME));
            String Passw=c.getString(c.getColumnIndexOrThrow(COLUMN_PASSWORD));
            ls.add(FName+" / "+UName+" / "+Passw);
            c.moveToNext();
        }
        return ls;
    }
}
