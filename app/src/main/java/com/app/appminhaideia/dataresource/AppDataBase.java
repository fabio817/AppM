package com.app.appminhaideia.dataresource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.app.appminhaideia.datamodel.ClienteDataModel;
import com.app.appminhaideia.utils.AppUtils;


public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "Milk.sqlite";
    public static final int DB_VERSION = 1;

    // acessando o banco de dados
    SQLiteDatabase db;


    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        // pegando o banco de dados pra escrita
        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // execultando o metodo cliente data model pra criar tabela
        db.execSQL(ClienteDataModel.criarTabela());
        //pronto pra cria a tabela no bando de dados

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

/**
* metodo pra incluir dados no banco de dados
* */
                                         // passando os dados
    public boolean inserir(String tabela, ContentValues dados){

        db = getWritableDatabase();

        boolean retorno = false;

        try {

            retorno = db.insert(tabela, null,dados) > 0;

        } catch (Exception e){

            Log.e(AppUtils.TAG, "inserir: Erro ao inserir os dados....."+e.getMessage() );
            
        };

        return retorno;
    }
}
