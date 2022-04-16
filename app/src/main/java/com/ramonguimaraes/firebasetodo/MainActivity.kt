package com.ramonguimaraes.firebasetodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = TaskDaoImpl(this)

        dao.insert(Task("Comprar carvão", false))
        dao.insert(Task("Comprar carne", false))
        dao.insert(Task("Comprar refrigerante", false))
        dao.insert(Task("Comprar cerveja", false))
        dao.insert(Task("Comprar batata", false))


        val recyclerViewTodoList = findViewById<RecyclerView>(R.id.recyclerViewTodoList)

        recyclerViewTodoList.adapter = TodoListAdapter(arrayListOf())
        recyclerViewTodoList.layoutManager = LinearLayoutManager(this)
    }
}

class TaskItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun binding(task: Task) {
        val textViewTitle = itemView.findViewById<TextView>(R.id.textViewTaskTitle)
        val checkBoxCompleted = itemView.findViewById<CheckBox>(R.id.checkBoxCompleted)

        textViewTitle.text = task.title
        checkBoxCompleted.isChecked = task.completed
    }
}

class TodoListAdapter(private val todoList: List<Task>) :
    RecyclerView.Adapter<TaskItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_layout, parent, false)
        return TaskItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        holder.binding(todoList[position])
    }

    override fun getItemCount() = todoList.size
}