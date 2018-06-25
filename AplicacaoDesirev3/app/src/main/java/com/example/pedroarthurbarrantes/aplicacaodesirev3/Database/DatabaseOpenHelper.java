package com.example.pedroarthurbarrantes.aplicacaodesirev3.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "data.db";
    private static final String TABLE_NAME = "tb_rV";
    private static final String CREATE_TABLE = "CREATE TABLE tb_rV ( 'id' INTEGER PRIMARY KEY AUTOINCREMENT, 'nome' TEXT NOT NULL, 'url' BLOB NOT NULL, 'info' TEXT, 'acom' TEXT, 'end' TEXT, 'hor' TEXT, 'map' BLOB )";
    private static final int DATABASE_VERSION = 1;

    //construtor

    public DatabaseOpenHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);

        db.execSQL("DROP TABLE IF EXISTS tb_rV");
        db.execSQL(CREATE_TABLE);
        onCreate(db);



    }


}
