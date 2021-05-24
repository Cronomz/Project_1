package com.example.first

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.project_page.*
import kotlin.concurrent.fixedRateTimer
import com.example.first.FragCom as FragCom

class MainActivity() : AppCompatActivity(), FragCom {
    lateinit var projectAdapter: ProjectAdapter
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Coming soon", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        fab.bringToFront()
        black_bar.bringToFront()
        text_input.bringToFront()
        add_button.bringToFront()

        val mainFragment = MainFragment()
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main, mainFragment).commit()

        projectAdapter = ProjectAdapter(mutableListOf())


        add_button.setOnClickListener {
            if (text_input.text != null) {
                projectAdapter.addProject(ItemProject(text_input.text.toString(), mutableListOf(), false))
                text_input.text = null
                rvProjectItems.adapter = projectAdapter
                rvProjectItems.layoutManager = LinearLayoutManager(mainFragment.context)
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun passDataCom(project: ItemProject) {
        val bundle = Bundle()
        bundle.putString("name", project.name)


        val transaction = this.supportFragmentManager.beginTransaction()
        val projFrag = ProjectFragment()
        projFrag.arguments = bundle

        transaction.replace(R.id.nav_host_fragment_content_main, projFrag)
        transaction.commit()
    }
}