package com.example.android.amaliayovadiani_1202154301_studycase5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {
    Context konteks;
    SQLiteDatabase data_base;

    public static final String nama_db = "listtodo_db";
    public static final String nama_tabel = "daftartodo";
    public static final String kolom_1 = "todo";
    public static final String kolom_2 = "description";
    public static final String kolom_3 = "priority";

    public database (Context context) {
        super(context, nama_db, null, 1);
        this.konteks = context;
        data_base = this.getWritableDatabase();
        data_base.execSQL("create table if not exists "+nama_tabel+" (todo varchar(35) primary key, description varchar(50), priority varchar(3))");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { //database dibuat
        sqLiteDatabase.execSQL("create table if not exists "+nama_tabel+" (todo varchar(35) primary key, description varchar(50), priority varchar(3))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+nama_tabel);
        onCreate(sqLiteDatabase);
    }

    public boolean inputdata(dataKegiatan list) {
        ContentValues val = new ContentValues();
        val.put(kolom_1, list.getTodo());
        val.put(kolom_2, list.getDesc());
        val.put(kolom_3, list.getPrior());
        long hasil = data_base.insert(nama_tabel, null, val);
        if (hasil==-1) {
            return false;
        }else {
            return true;
        }
    }

    public boolean removedata(String ToDo) {
        return data_base.delete(nama_tabel, kolom_1+"=\""+ToDo+"\"", null)>0;
    }

    public void readdata(ArrayList<dataKegiatan> daftar){
        Cursor cursor = this.getReadableDatabase().rawQuery("select todo, description, priority from "+nama_tabel, null);
        while (cursor.moveToNext()){
            daftar.add(new dataKegiatan(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
        }
    }
}

