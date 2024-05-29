package tn.essat.gestiondesmatieres;

import androidx.annotation.Nullable;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class Mabase extends SQLiteOpenHelper {
    String base1=" CREATE TABLE matiere(id INTEGER PRIMARY KEY AUTOINCREMENT ,Titre TEXT , Niveau TEXT);";

    public Mabase(@Nullable Context context, @Nullable String name,
                  @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(base1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE matiere;");
        onCreate(sqLiteDatabase);
    }
}