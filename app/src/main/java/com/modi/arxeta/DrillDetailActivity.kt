package com.modi.arxeta

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.modi.arxeta.databinding.ActivityDrillDetailBinding

class DrillDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDrillDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrillDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drillName = intent.getStringExtra("DRILL_NAME") ?: "Drill"

        binding.tvTitle.text = drillName
        binding.tvDescription.text = "Description for $drillName"
        binding.tvTips.text = "Tips: Tap on the ground to place the drill marker."

        binding.btnLaunchAR.setOnClickListener {
            val intent = Intent(this, ARActivity::class.java)
            startActivity(intent)
        }
    }
}