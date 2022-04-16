package com.ramonguimaraes.firebasetodo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(private val context: Context) : SQLiteOpenHelper(context, "firebase_todo.db", null, 1) {
    private var mInstance: DatabaseHelper? = null

    fun getInstance(): DatabaseHelper {
        if (mInstance == null) {
            mInstance = DatabaseHelper(context)
        }

        return mInstance as DatabaseHelper
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val taskTable =
            "CREATE TABLE IF NOT EXISTS task (id INTEGER PRIMARY KEY NOT NULL, title TEXT, completed INTEGER);"

        db?.execSQL(taskTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val dropTableTask = "DROP TABLE IF EXISTS task;"
        db?.execSQL(dropTableTask)
    }
}