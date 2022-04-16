package com.ramonguimaraes.firebasetodo

import android.content.ContentValues
import android.content.Context
import android.util.Log
import java.sql.SQLException

class TaskDaoImpl(private val context: Context) : TaskDao {
    override fun insert(task: Task): Long {
        var id = 0L
        val db = DatabaseHelper(context).getInstance().writableDatabase

        try {
            val contentValues = ContentValues()
            contentValues.put("title", task.title)
            contentValues.put("completed", if (task.completed) 1 else 0)

            id = db.insertOrThrow("task", null, contentValues)
        } catch (e: SQLException) {
            Log.e("erro", e.toString())
        } finally {
            db.close()
        }

        return id
    }

    override fun update(task: Task) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Task> {
        TODO("Not yet implemented")
    }

    override fun getTask(id: Long): Task {
        TODO("Not yet implemented")
    }
}