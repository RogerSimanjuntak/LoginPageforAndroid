package db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import model.user;

public class DbHelper extends SQLiteOpenHelper {

    public static final String database_name="db_user";
    public static final String table_name="table_user";
    public static final String row_id="id";
    public static final String row_email = "email";
    public static final String row_username = "Username";
    public static final String row_password = "Password";

    private SQLiteDatabase db;

    public DbHelper(Context context) {
        super(context, database_name, null, 1);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + table_name +"(" + row_id+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + row_email+" TEXT,"+ row_username + " TEXT," + row_password + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
    }

    public void insertData(ContentValues values){
        db.insert(table_name,null,values);
    }

    public boolean checkUser (String username, String password){
        String[] columns = {row_id};
        SQLiteDatabase db = getReadableDatabase();
        String selection =   row_username +"=?" +" and " + row_password +"=?";
        String[] selectionArgs = {username,password};
        Cursor cursor = db.query(table_name,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return true;
        else
            return false;
    }
    public boolean datauser(String username, String password, String email){

        return true;
    }

    public ArrayList<user> searchUser(String email){
        ArrayList<user> arraylist = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM "+table_name+" WHERE username='"+email+"'",null);
        cursor.moveToFirst();
        user user;
        if(cursor.getCount()>0){
            do {
                user = new user();
                user.setId(cursor.getInt(cursor.getColumnIndexOrThrow(row_id)));
                user.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(row_email)));
                user.setName(cursor.getString(cursor.getColumnIndexOrThrow(row_username)));
                user.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(row_password)));
                arraylist.add(user);
                cursor.moveToNext();
            } while(!cursor.isAfterLast());
        }
        cursor.close();
        return arraylist;
    }
}