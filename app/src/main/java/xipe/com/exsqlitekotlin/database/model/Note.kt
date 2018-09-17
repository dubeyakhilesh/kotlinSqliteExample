package xipe.com.exsqlitekotlin.database.model

class Note {
    var note: String = ""
    var timeStamp: String = ""

    val TABLE_NAME: String = "notes"

    val COLUMN_ID: String = "id"
    val COLUMN_NOTE: String = "note"
    val COLUMN_TIME: String = "time"

    /*-----------------Query-------------*/
    val CREATE_TABLE: String = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NOTE + " Text," +
            COLUMN_TIME + " Text )"

    val DROP_TABLE: String = "DROP TABLE IF EXISTS " + TABLE_NAME
    val SELECT_ALL_RECORD = "SELECT * FROM " + TABLE_NAME

    constructor(){

    }

    constructor( note: String, timeStamp: String){
        this.note = note
        this.timeStamp = timeStamp
    }

    fun setNotes(note: String){
        this.note = note
    }

    fun getNotes(): String{
        return note
    }

    fun setTimeStamps(timeStamp: String){
        this.timeStamp = timeStamp
    }

    fun getTimeStamps(): String{
        return timeStamp
    }

}