package com.example.calculadora;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {


    private static final String DB_NAME = "forumdb.db";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "optable";

    private static final String ID_COL = "id";

    private static final String OP_COL = "operacao";

    private static final String RESULT_COL = "resultado";


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + OP_COL + " TEXT,"
                + RESULT_COL + " TEXT)";


        db.execSQL(query);
    }

    public void addOp(String opTxt, String resultTxt) {


        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(OP_COL, opTxt);
        values.put(RESULT_COL, resultTxt);


        db.insert(TABLE_NAME, null, values);


        db.close();
    }

    public ArrayList<OpModal> readOp() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorOp = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<OpModal> opModalArrayList = new ArrayList<>();

        if (cursorOp.moveToFirst()) {
            do {
                opModalArrayList.add(new OpModal(cursorOp.getString(1),
                        cursorOp.getString(2)));
            } while (cursorOp.moveToNext());
        }
        cursorOp.close();
        return opModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}