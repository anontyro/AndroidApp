package co.alexwilkinson.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Alex on 17/10/2016.
 * Used for the LoginActivity
 */

public class DBManager {
    private SQLiteDatabase sqlDB;

    static final String dbName = "FirstAppDB";
    static final String tableName="Login";
    static final String colUsername = "Username";
    static final String colPassword = "Password";
    static final int dbVersion = 1;

    static final String createTable="CREATE TABLE IF NOT EXISTS "+tableName
            +" (ID integer PRIMARY KEY AUTOINCREMENT,"+colUsername
            +" TEXT,"+colPassword + " TEXT);";

    public DBManager(Context context){
        DatabaseHelper db = new DatabaseHelper(context);
        sqlDB = db.getWritableDatabase();

    }
    //insert command, id is user id fails if id == 0
    public long insert(ContentValues values){
        long id = sqlDB.insert(tableName,"",values);

        return id;
    }

    static class DatabaseHelper extends SQLiteOpenHelper{
        Context context;
        DatabaseHelper(Context context){
            super(context, dbName,null,dbVersion);
            this.context = context;

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(createTable);
            Toast.makeText(context,"Database has been created",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
            db.execSQL("DROP TABLE IF EXISTS" + tableName);
            onCreate(db);
        }
    }
}
