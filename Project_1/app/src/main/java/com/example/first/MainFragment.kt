package com.example.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first.databinding.ProjectPageBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.project_page.*

class MainFragment: Fragment() {

    private lateinit var projectAdapter: ProjectAdapter

    private var _binding: ProjectPageBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ProjectPageBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        projectAdapter = ProjectAdapter(mutableListOf())
        rvProjectItems.adapter = projectAdapter

        add_button.setOnClickListener{
            val projectTitle = text_input.text.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}