package xipe.com.exsqlitekotlin.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import xipe.com.exsqlitekotlin.R
import xipe.com.exsqlitekotlin.database.DatabaseHelper
import xipe.com.exsqlitekotlin.database.model.Note

class MainActivity : AppCompatActivity() {

    val DATABASE_NAME: String = "notes_db"
    val DATABASE_VERSION: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        var databaseHelper = DatabaseHelper(this, DATABASE_NAME, DATABASE_VERSION)
        var i = 0
        var btnAdd = findViewById(R.id.btnAdd) as Button
        btnAdd.setOnClickListener {
            i += i
            var note = Note("notes" + i, "Time" + i)
            var n = databaseHelper.insertRecord(note)
            Toast.makeText(this, "Record Response : " + n, Toast.LENGTH_LONG).show()
        }

        val btnFetch = findViewById<Button>(R.id.btnFetch)
        btnFetch.setOnClickListener {
            var notes: ArrayList<Note> = databaseHelper.fetchAllRecord()
            Toast.makeText(this, "Number of Records are : " + notes.size, Toast.LENGTH_LONG).show()
        }
    }
}
