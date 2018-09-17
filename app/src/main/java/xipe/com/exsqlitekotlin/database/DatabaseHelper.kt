package xipe.com.exsqlitekotlin.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import xipe.com.exsqlitekotlin.database.model.Note

class DatabaseHelper: SQLiteOpenHelper {
    lateinit var context: Context
    lateinit var note: Note
    constructor(context: Context, databaseName: String, databaseVersion: Int): super(context, databaseName, null, databaseVersion){
        this.context = context
        note = Note()
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL(note.DROP_TABLE)
        onCreate(p0)
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(note.CREATE_TABLE)
    }

    fun insertRecord(note: Note): Long{
        var sqLiteDatabase: SQLiteDatabase = this.writableDatabase
        var contentValue: ContentValues = ContentValues()
        contentValue.put(note.COLUMN_NOTE, note.getNotes())
        contentValue.put(note.COLUMN_TIME, note.getTimeStamps())

        var id = sqLiteDatabase.insert(note.TABLE_NAME, null, contentValue)
        sqLiteDatabase.close()
        return id
    }

    fun fetchAllRecord(): ArrayList<Note>{
        var notes: ArrayList<Note> = ArrayList<Note>();
        var sqLiteDatabase: SQLiteDatabase = this.writableDatabase
        var cursor = sqLiteDatabase.rawQuery(note.SELECT_ALL_RECORD, null)

        if (cursor.moveToFirst()){
            do {
                var not = cursor.getString(cursor.getColumnIndex(note.COLUMN_NOTE))
                var time = cursor.getString(cursor.getColumnIndex(note.COLUMN_TIME))
                var note = Note(not, time)
                notes.add(note)
            }while (cursor.moveToNext())
        }

        sqLiteDatabase.close()
        return notes
    }
}