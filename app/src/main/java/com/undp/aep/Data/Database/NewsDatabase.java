package com.undp.aep.Data.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;

import androidx.annotation.Nullable;

import com.undp.aep.ui.Fragment.NewsFragment;

import java.sql.Date;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class NewsDatabase extends SQLiteOpenHelper {
    public  SQLiteDatabase db=null;

    public NewsDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        db=getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE if not exists [News](\n" +
                "  [ID] INT, \n" +
                "  [Title] NVARCHAR, \n" +
                "  [Description] NVARCHAR, \n" +
                "  [Type] INT, \n" +
                "  [Date] NVARCHAR(10), \n" +
                "  [Image] NVARCHAR(50));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void Insert(int ID, String Title, String Description, int Type, String Date, String Image){
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID",ID);
        contentValues.put("Title",Title);
        contentValues.put("Description",Description);
        contentValues.put("Type",Type);
        contentValues.put("Date", Date);
        contentValues.put("Image", Image);

        db.insert("News",null,contentValues);
    }
    public void Update(int ID, String Title, String Description, int Type, String Date, String Image){
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID",ID);
        contentValues.put("Title",Title);
        contentValues.put("Description",Description);
        contentValues.put("Type",Type);
        contentValues.put("Date", Date);
        contentValues.put("Image", Image);
        db.update("News",contentValues,"ID="+ID,null);
    }
   /* public void Delete(int ID){
        db.delete("News","ID="+ID,null);
    }*/
    public void Delete(){
        db.delete("News",null,null);
    }
    public Cursor getImage(){
        return db.rawQuery("select Image from News",null);
    }
    public Cursor getID(){
        return db.rawQuery("select ID from News",null);
    }
    public Cursor getDescription(){
        return db.rawQuery("select Description from News",null);
    }
    public Cursor getType(){
        return db.rawQuery("select Type from News",null);
    }
    public Cursor getDate(){
        return db.rawQuery("select Date from News",null);
    }
    public Cursor getAll(){
        return db.rawQuery("select * from News",null);
    }
}
