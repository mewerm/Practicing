package com.example.chaindaggerretrorecyclermvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chaindaggerretrorecyclermvvm.R
import com.example.chaindaggerretrorecyclermvvm.model.RecyclerList
import com.example.chaindaggerretrorecyclermvvm.ui.adapter.RecyclerViewAdapter
import com.example.chaindaggerretrorecyclermvvm.ui.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerViewAdapter
    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        mainActivityViewModel.getLiveDataObserver().observe(this, object : Observer<RecyclerList> {
            override fun onChanged(t: RecyclerList?) {
                if (t != null) {
                    recyclerViewAdapter.setUpdateData(t.items)
                    recyclerViewAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(
                        baseContext,
                        "error in getting the date",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })
        mainActivityViewModel.makeApiCall()
    }
}