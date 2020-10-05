package com.example.sampleintegration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NativeIconsActivity : AppCompatActivity() {

    lateinit var viewModel: NativeIconsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native_icons)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "Native Icons"

        val recyclerView = findViewById<RecyclerView>(R.id.iconsRecyclerView)
        viewModel = ViewModelProvider(this).get(NativeIconsViewModel::class.java)

        val iconsAdapter = NativeIconsListAdapter(this, viewModel.icons)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = iconsAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}