package com.yudhistira.mymobileapp.modul.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.yudhistira.mymobileapp.base.Task;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "MYMOBILEAPP.DB";

    public static final String TASK_TABLE_NAME = "TASK";
    public static final String TASK_ID = "_id";
    public static final String TASK_NAME = "name";
    public static final String TASK_DETAIL = "detail";
    public static final String TASK_DONE = "done";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table "+TASK_TABLE_NAME+" " +
                        "("+TASK_ID+" integer primary key autoincrement, "
                        +TASK_NAME+" text, "
                        +TASK_DETAIL+ " text,"
                        +TASK_DONE+" integer)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TASK_TABLE_NAME);
        onCreate(db);
    }

    public Cursor getTask(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TASK_TABLE_NAME+ " where "+TASK_ID+"="+id+"", null );
        return res;
    }

    public int numberOfRowsTask(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TASK_TABLE_NAME);
        return numRows;
    }

    public ArrayList<Task> getAllTask() {
        ArrayList<Task> array_list = new ArrayList<Task>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TASK_TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            int id = res.getInt(res.getColumnIndex(TASK_ID));
            String name = res.getString(res.getColumnIndex(TASK_NAME));
            String detail = res.getString(res.getColumnIndex(TASK_DETAIL));
            int done_int = res.getInt(res.getColumnIndex(TASK_DONE));

            Task task = new Task();
            task.setId(id);
            task.setName(name);
            task.setDetail(detail);
            task.setDone( done_int == 1 );

            array_list.add(task);

            res.moveToNext();
        }
        return array_list;
    }

    public boolean insertTask (Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TASK_NAME, task.getName());
        contentValues.put(TASK_DETAIL, task.getDetail());
        if(task.isDone()){
            contentValues.put(TASK_DONE, 1);
        } else {
            contentValues.put(TASK_DONE, 0);
        }

        db.insert(TASK_TABLE_NAME, null, contentValues);
        return true;
    }

    public boolean updateTask (Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TASK_NAME, task.getName());
        contentValues.put(TASK_DETAIL, task.getDetail());
        if(task.isDone()){
            contentValues.put(TASK_DONE, 1);
        } else {
            contentValues.put(TASK_DONE, 0);
        }
        db.update(TASK_TABLE_NAME, contentValues, TASK_ID+" = ? ", new String[] { Integer.toString(task.getId()) } );
        return true;
    }

    public int deleteTask(Task task){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TASK_TABLE_NAME,
                TASK_ID+" = ? ",
                new String[] { Integer.toString(task.getId()) });
    }
}
