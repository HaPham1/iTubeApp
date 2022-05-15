package com.example.itubeapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.itubeapp.model.Playlist;
import com.example.itubeapp.util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    public DatabaseHelper2(@Nullable Context context) {
        super(context, Util.DATABASE_NAME_2, null, Util.DATABASE_VERSION_2);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_USER_TABLE = "CREATE TABLE " + Util.TABLE_NAME_2 + "(" + String.valueOf(Util.PLAYLIST_ID) + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Util.USERNAME + " TEXT," + Util.URL + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP_USER_TABLE = "DROP TABLE IF EXISTS ";
        sqLiteDatabase.execSQL(DROP_USER_TABLE + Util.TABLE_NAME_2 + ";");

        onCreate(sqLiteDatabase);
    }

    public long insertPlaylist (Playlist playlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Util.USERNAME, playlist.getUsername());
        contentValues.put(Util.URL, playlist.getUrl());

        long newRowId = db.insert(Util.TABLE_NAME_2, null, contentValues);
        db.close();
        return newRowId;
    }


    public List<Playlist> fetchSelectedLists (String username) {
        List<Playlist> urlList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.TABLE_NAME_2, null, Util.USERNAME + "=?" , new String[] {username}, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Playlist playlist = new Playlist();
                playlist.setPlaylist_id(cursor.getInt(cursor.getColumnIndex(Util.PLAYLIST_ID)));
                playlist.setUsername(cursor.getString(cursor.getColumnIndex(Util.USERNAME)));
                playlist.setUrl(cursor.getString(cursor.getColumnIndex(Util.URL)));
                urlList.add(playlist);

            } while (cursor.moveToNext());
        }
        return urlList;
    }

}
