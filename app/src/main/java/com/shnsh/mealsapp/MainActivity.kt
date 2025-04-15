package com.shnsh.mealsapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MealsViewModel by viewModels()
    private lateinit var mealsAdapter: MealsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.category_rv)
        mealsAdapter = MealsAdapter()
        recyclerView.adapter = mealsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this) // <- Make sure layout manager is set!

        viewModel.getMeals() // Trigger the API call

        // Observe data from ViewModel
        lifecycleScope.launch {
            viewModel.categories.collectLatest { response ->
                val list = response?.categories
                if (list != null) {
                    mealsAdapter.submitList(list)
                }
            }
        }
    }
}
