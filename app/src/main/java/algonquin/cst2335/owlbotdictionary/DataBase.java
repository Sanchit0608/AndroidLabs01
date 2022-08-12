package algonquin.cst2335.owlbotdictionary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    public static final String OWLBOT_TABLE = "OWLBOT_TABLE";
    public static final String OWLBOT_WORD = "OWLBOT_WORD";
    public static final String OWLBOT_DEFINITION = "OWLBOT_DEFINITION";
    public static final String OWLBOT_PRONUNCIATION = "OWLBOT_PRONUNCIATION";
    public static final String OWLBOT_ID = "_id";

    public DataBase(@Nullable Context context) {
        super(context, "OwlBotDictionary.db", null, 1);
    }

    //Method is called to create a database if it doesn't exist.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + OWLBOT_TABLE + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + OWLBOT_WORD + " TEXT, " + OWLBOT_DEFINITION + " TEXT, " + OWLBOT_PRONUNCIATION + " TEXT)";
        db.execSQL(createTable);

    }

    //Method is called if newer database is constructed
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + OWLBOT_TABLE);

    }

    public boolean insert(String word, String def, String pro) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DataBase.OWLBOT_WORD, word);
        cv.put(DataBase.OWLBOT_DEFINITION, def);
        cv.put(DataBase.OWLBOT_PRONUNCIATION, pro);

        long result = db.insert(OWLBOT_TABLE, null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean delete(String word, String def, String pro) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DataBase.OWLBOT_WORD, word);
        cv.put(DataBase.OWLBOT_DEFINITION, def);
        cv.put(DataBase.OWLBOT_PRONUNCIATION, pro);

        long result = db.delete(OWLBOT_TABLE, DataBase.OWLBOT_ID + "= ?", null);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

}
