package com.example.passwords;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PASSWORD";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLO_PASSWORDS = "passwords";
    private static final String ROW_ID = "id";
    private static final String ROW_HESAP_ADI = "hesap_adi";
    private static final String ROW_NAME = "name";
    private static final String ROW_PASSWORD = "password";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLO_PASSWORDS + "("
                + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROW_HESAP_ADI + " TEXT NOT NULL, "
                + ROW_NAME + " TEXT NOT NULL, "
                + ROW_PASSWORD + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLO_PASSWORDS);
        onCreate(db);
    }

    public void VeriEkle(String hesap_adi, String name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_HESAP_ADI, hesap_adi);
            cv.put(ROW_NAME, name);
            cv.put(ROW_PASSWORD, password);
            db.insert(TABLO_PASSWORDS, null,cv);
        }catch (Exception e){
        }
        db.close();
    }


    public List<String> VeriListele(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {ROW_ID,ROW_HESAP_ADI,ROW_NAME,ROW_PASSWORD};
            Cursor cursor = db.query(TABLO_PASSWORDS, stunlar,null,null,null,null,null);
            while (cursor.moveToNext()){
                veriler.add(cursor.getInt(0)
                        + " - "
                        + cursor.getString(1)
                        + " - "
                        + cursor.getString(2)
                        + " - "
                        + cursor.getString(3));
            }
        }catch (Exception e){
        }
        db.close();
        return veriler;
    }

    public void VeriSil(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            // id ye göre verimizi siliyoruz
            String where = ROW_ID + " = " + id ;
            db.delete(TABLO_PASSWORDS,where,null);
        }catch (Exception e){
        }
        db.close();
    }

    public void VeriDuzenle(int id, String hesapad, String name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_HESAP_ADI, hesapad);
            cv.put(ROW_NAME, name);
            cv.put(ROW_PASSWORD, password);
            String where = ROW_ID +" = '"+ id + "'";
            db.update(TABLO_PASSWORDS,cv,where,null);
        }catch (Exception e){
        }
        db.close();
    }
}