package com.junkakeno.sportsbuddy.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static final String TAG = Database.class.getSimpleName();
    private static final String DB_NAME = "TeamsDB";
    private static final int DB_VER = 1;
    public static final String FAVORITE_TABLE = "FavoriteTable";
    public static final String SUBSCRIPTION_TABLE = "SubscriptionTable";
    public static final String COL_TEAM_ID = "teamId";
    public static final String COL_SUBSCRIPTION = "subscription";


    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");
        String createFavoriteTable = "CREATE TABLE " + FAVORITE_TABLE + "( " + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_TEAM_ID + " TEXT )";
        String createSubscriptionTable = "CREATE TABLE " + SUBSCRIPTION_TABLE + "( " + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_SUBSCRIPTION + " TEXT )";
        db.execSQL(createFavoriteTable);
        db.execSQL(createSubscriptionTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade");
        String deleteFavoriteTable = "DROP TABLE IF EXISTS " + FAVORITE_TABLE;
        String deleteSubscriptionTable = "DROP TABLE IF EXISTS " + SUBSCRIPTION_TABLE;
        db.execSQL(deleteFavoriteTable);
        db.execSQL(deleteSubscriptionTable);
        onCreate(db);
    }

    /*Helper Methods.*/
    public void saveFavorite(String teamId) {

        /*Insert the info into the database.*/
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(COL_TEAM_ID, teamId);
        db.insert(FAVORITE_TABLE, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public void saveSubscription(String subscription) {

        /*Insert the info into the database.*/
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(COL_SUBSCRIPTION, subscription);
        db.insert(SUBSCRIPTION_TABLE, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public void deleteFavorite(String teamId) {

        /*Insert the info into the database.*/
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        db.delete(FAVORITE_TABLE, COL_TEAM_ID + "=?", new String[]{teamId});
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public void clearFavoriteTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + FAVORITE_TABLE);
        db.close();
    }

    public void clearSubscriptionTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + SUBSCRIPTION_TABLE);
        db.close();
    }

    public ArrayList<String> getFavorites() {

        ArrayList<String> favoriteList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(FAVORITE_TABLE, new String[]{COL_TEAM_ID}, null, null, null, null, BaseColumns._ID + " ASC");

        if (cursor.moveToFirst()) {
            do {
                String teamId = cursor.getString(cursor.getColumnIndex(COL_TEAM_ID));
                favoriteList.add(teamId);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return favoriteList;
    }

    public ArrayList<String> getSubscription() {

        ArrayList<String> subscriptions = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(SUBSCRIPTION_TABLE, new String[]{COL_SUBSCRIPTION}, null, null, null, null, BaseColumns._ID + " ASC");

        if (cursor.moveToFirst()) {
            do {
                String subscription = cursor.getString(cursor.getColumnIndex(COL_SUBSCRIPTION));
                subscriptions.add(subscription);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return subscriptions;
    }

}
