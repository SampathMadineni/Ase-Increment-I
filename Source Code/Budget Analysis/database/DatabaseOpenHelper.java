package com.example.bussinessanalsis.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

	private String tagActivity = "DatabaseOpenHelper";
	
	public DatabaseOpenHelper(Context context, String name,CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String login= "CREATE TABLE Login(loginid INTEGER PRIMARY KEY AUTOINCREMENT,lo_userid INTEGER NOT NULL,lo_logintime TEXT,lo_logouttime	TEXT,password TEXT,lo_isactive INTEGER)";
		String  register= "CREATE TABLE Register (reg_id INTEGER PRIMARY KEY AUTOINCREMENT, reg_userid text, password text,reg_isactive INTEGER)";
		
		
		try{
			db.execSQL(register);
			
			db.execSQL(login);
			
		}catch(Exception ex){
			Log.v(tagActivity, "@@ ERROR at creating database"+db.getPath());
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
        db.execSQL("DROP TABLE IF EXISTS Login"); 
        db.execSQL("DROP TABLE IF EXISTS Register"); 
      
        
        onCreate(db);
	}
	
	//600 -----> "Assign Time"
	//601 -----> "Departure Time"
	//602 -----> "Scene Arrival Time"
	//603 -----> "Scene Departure Time"
	//604 -----> "Destination Reach Time"
	//605 -----> "Patient Handover Time"
	//606 -----> "Vehicle Release Time"
	//607 -----> "Deassign Time"
	
	

	
}