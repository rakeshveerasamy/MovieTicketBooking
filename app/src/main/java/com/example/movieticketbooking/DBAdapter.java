package com.example.movieticketbooking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Calendar;
import java.util.logging.FileHandler;

public class DBAdapter {
    static final String KEY_ROWID = "_id";
    static final String KEY_NAME = "name";
    static final String KEY_Date= "date";
    static final String KEY_Timings= "timings";
    static final String KEY_Language= "language";
    static final String TAG = "DBAdapter";
    static final String DATABASE_NAME = "MyDB";
    static final String DATABASE_TABLE = "Movie";
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_CREATE =
            "create table Movie (_id integer primary key autoincrement, "
                    + "name text not null,date text not null , timings text not null,language text not null);";
     Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }
    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        DBHelper.close();
    }
    public long insertMovie(String name,String date, String timings,String language)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_Date, date);
        initialValues.put(KEY_Timings, timings);
        initialValues.put(KEY_Language, language);
       /* TimetoLive TTLObject  = new TimetoLive();
        String hour,minute;
        int hr,min;
        long totalmin;
        hour = timings.split("\\:")[0];
        minute = timings.split("\\:")[1];
        hr = Integer.parseInt(hour);
        min = Integer.parseInt(minute);
        totalmin = ((hr*60)+min)*60000;
        TTLObject.removeKey(name, totalmin);*/
        return db.insert(DATABASE_TABLE, null, initialValues);
    }
   public boolean deleteMovie(long rowId)
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }
    public boolean deleteMovie(String name)
    {
        return db.delete(DATABASE_TABLE, KEY_NAME + "=" + name, null) > 0;
    }
    public Cursor getAllMovies()
    {
        return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_NAME,KEY_Date,
                KEY_Timings,KEY_Language}, null, null, null, null, null);
    }
    public Cursor searchMovie(long rowId) throws SQLException
    {
        Cursor mCursor = db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                KEY_NAME,KEY_Date, KEY_Timings,KEY_Language}, KEY_ROWID + "=" + rowId, null,null, null, null, null);
        if (mCursor != null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public boolean updateMovie(long rowId, String name,String date , String timings,String language)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_Date, date);
        args.put(KEY_Timings, timings);
        args.put(KEY_Language, language);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
