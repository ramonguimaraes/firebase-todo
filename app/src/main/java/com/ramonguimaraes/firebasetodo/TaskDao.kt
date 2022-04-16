package com.ramonguimaraes.firebasetodo

interface TaskDao {
    fun insert(task: Task): Long
    fun update(task: Task)
    fun delete(id: Long)
    fun getAll(): List<Task>
    fun getTask(id: Long): Task
}