package com.example.first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.projects_item.view.*


class TaskAdapter (private val tasks: MutableList<ItemTask>) : RecyclerView.Adapter<TaskAdapter.ProjectViewHolder>() {

    class ProjectViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        return ProjectViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.projects_item, parent, false))
    }

    fun addTask(task: ItemTask) {
        tasks.add(task)
        notifyItemInserted(tasks.size - 1)
    }

    fun deleteTask(position: Int) {

    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val curProj = tasks[position]
        holder.itemView.apply {
            button_project.text = curProj.name
            project_progress_bar.progress = 1

            button_project.setOnClickListener{
                project_progress_bar.progress = 10
            }
        }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

}