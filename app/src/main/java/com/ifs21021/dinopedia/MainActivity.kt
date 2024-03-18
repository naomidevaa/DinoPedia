package com.example.dinopedia

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), FamilyItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rvFamilies)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = DinoFamilyAdapter(DinoFamily.getFamilyList(), this)
        recyclerView.adapter = adapter
    }

    override fun onFamilyItemClick(family: DinoFamily) {
        // Handle family item click event
        // Navigate to FamilyDetailActivity and pass the family name as an extra
        val intent = Intent(this, FamilyDetailActivity::class.java).apply {
            putExtra(FamilyDetailActivity.EXTRA_FAMILY_NAME, family.name)
        }
        startActivity(intent)
    }
}