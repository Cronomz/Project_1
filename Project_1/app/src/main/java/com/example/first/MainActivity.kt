package com.example.first

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var projectAdapter: ProjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Coming soon", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        fab.bringToFront()
        black_bar.bringToFront()
        text_input.bringToFront()
        button_first.bringToFront()

        projectAdapter = ProjectAdapter(mutableListOf())
        rvProjectItems.adapter = projectAdapter
        rvProjectItems.layoutManager = LinearLayoutManager(this)

        button_first.setOnClickListener{
            val projectTitle = text_input.text.toString()
            if (projectTitle.isNotEmpty()) {
                projectAdapter.addProject(ItemProject(projectTitle, mutableListOf(), false))
                text_input.text.clear()
            }
        }

    }


}