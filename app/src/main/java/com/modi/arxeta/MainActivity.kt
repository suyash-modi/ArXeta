package com.modi.arxeta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ArrayAdapter
import com.modi.arxeta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val drills = listOf("Drill 1", "Drill 2", "Drill 3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, drills)
        binding.spinner.adapter = adapter

        binding.btnStart.setOnClickListener {
            val selected = binding.spinner.selectedItem.toString()
            val intent = Intent(this, DrillDetailActivity::class.java)
            intent.putExtra("DRILL_NAME", selected)
            startActivity(intent)
        }
    }
}