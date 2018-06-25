package com.example.pedroarthurbarrantes.aplicacaodesirev3.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pedroarthurbarrantes.aplicacaodesirev3.RecyclerViewAdapter;

public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    //construtor privado

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //retornando a instancia do banco

    public static DatabaseAccess getInstance(Context context){
        if (instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //para abrir a conexao

    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    //para fechar a conexao

    public void close(){
        this.db.close();
    }


    public String getNome(String name){
        c=db.rawQuery("SELECT nome from tb_rV where nome='" + name + "'", null);
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String address = c.getString(0);
            buffer.append(""+address);
        }
        return buffer.toString();
    }

    public String getInfo(String info){
        c=db.rawQuery("SELECT info from tb_rV where nome='" + info + "'",null);
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String informacao = c.getString(0);
            buffer.append(""+informacao);
        }
        return buffer.toString();
    }

    public String getAco(String aco){
        c=db.rawQuery("SELECT acom from tb_rV where nome='" + aco + "'",null);
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String acomodacoes = c.getString(0);
            buffer.append(""+acomodacoes);
        }
        return buffer.toString();
    }

    public String getEnd(String end){
        c=db.rawQuery("SELECT end from tb_rV where nome='" + end + "'",null);
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String endereco = c.getString(0);
            buffer.append(""+endereco);
        }
        return buffer.toString();
    }


    public String getHor(String hor){
        c=db.rawQuery("SELECT hor from tb_rV where nome='" + hor + "'",null);
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String horario = c.getString(0);
            buffer.append(""+horario);
        }
        return buffer.toString();
    }

    public String getMap(String map){
        c=db.rawQuery("SELECT map from tb_rV where nome='" + map + "'",null);
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String mapa = c.getString(0);
            buffer.append(""+mapa);
        }
        return buffer.toString();
    }


}
