package com.example.bussinessanalsis.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



public class DataBaseConector {
	private String tagActivity = "DatabaseConnector";

	private static final String DB_NAME = "Bussiness_Analysis";
	private SQLiteDatabase database;
	private DatabaseOpenHelper dbOpenHelper;

	public DataBaseConector(Context context) {
		dbOpenHelper = new DatabaseOpenHelper(context, DB_NAME, null, 111);
	}

	public void open() throws SQLException {
		// open database in reading/writing mode
		database = dbOpenHelper.getWritableDatabase();
	}

	public void close() {
		if (database != null)
			database.close();
	}
	
	public long insert_register(ContentValues values) {
		// TODO Auto-generated method stub
		long result=0;
		try
		{
			open();
			Log.v(tagActivity, " Register details status " + values.toString());
			result=database.insert("Register",null,values);
			
			Log.v(tagActivity, "@ insert Register  result" + result);
			
		}
		catch(Exception e)
		{
			Log.v(tagActivity, "@ insert Register  result" + e.getMessage());
		}
		  close();
		return result;
	}
	 public String get_userdetails(String user_id)
	   {
		   Cursor cursor = null;
		   String result=null;
		   try {
		   open();
		   String selectQuery= "SELECT reg_userid from Register  WHERE reg_userid LIKE '"+user_id+"'";
		   cursor = database.rawQuery(selectQuery, null);
		   if (cursor.moveToFirst()) {
			   do {// cursor.getString(0)
				   if (cursor.getString(0) != null
							) {
						result=cursor.getString(0);
						Log.i("get_userdetails",result);
						/*callerslist.add(cursor.getString(0));*/
						}
						} while (cursor.moveToNext());
						}

							 
						}
						catch (Exception ex) {
								Log.e("error", "@@ ERROR atget_userdetails()()", ex);
								ex.printStackTrace();
							}
						finally {
							 if (cursor != null) {
								cursor.close();
							}
							 close();
						}
						return result;
						}
	 public String getuser_credentials(String userid, String pswd)
	   {
		   Cursor cursor = null;
		   String result=null;
		   try {
		   open();
		   String selectQuery= "SELECT reg_userid from Register  WHERE password LIKE '"+pswd+"' AND reg_userid LIKE'"+userid+"'";
		   Log.i("select query",selectQuery.toString());
		   cursor = database.rawQuery(selectQuery, null);
		   if (cursor.moveToFirst()) {
			   do {// cursor.getString(0)
				   if (cursor.getString(0) != null
							) {
						result=cursor.getString(0);
						Log.i("get_userdetails",result);
						/*callerslist.add(cursor.getString(0));*/
						}
						} while (cursor.moveToNext());
						}

							 
						}
						catch (Exception ex) {
								Log.e("error", "@@ ERROR atget_userdetails()()", ex);
								ex.printStackTrace();
							}
						finally {
							 if (cursor != null) {
								cursor.close();
							}
							 close();
						}
						return result;
						}
}
