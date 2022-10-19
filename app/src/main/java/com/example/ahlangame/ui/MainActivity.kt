package com.example.ahlangame.ui

import Callback
import Controller
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.ahlangame.R
import com.example.ahlangame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Callback {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getStringExtra("data")
        binding.tvnama3.text = data

        val btnPemain = arrayOf(
            binding.btn1,
            binding.btn2,
            binding.btn3,
        )
        val btnComputer = arrayOf(
            binding.btn4,
            binding.btn5,
            binding.btn6,
        )
        val controller = Controller(this)
        var data1 = ""
        var data2 = ""


        btnPemain.forEach { imageView ->
            imageView.setOnClickListener {
                imageView.selected()
                data1 = imageView.contentDescription.toString().lowercase()
                btnComputer.random().selected()
                data2 = imageView.contentDescription.toString().lowercase()
                controller.banding(data1, data2)
                binding.btn1.isEnabled = false
                binding.btn2.isEnabled = false
                binding.btn3.isEnabled = false
            }
        }

        binding.btn7.setOnClickListener {
            binding.tvResult.text = "VS"
            btnPemain.forEach { it.unselected() }
            btnComputer.forEach { it.unselected() }
            binding.btn1.isEnabled = true
            binding.btn2.isEnabled = true
            binding.btn3.isEnabled = true
        }
        binding.menuCPU.setOnClickListener {
            val intent = Intent (this, MainActivity5::class.java)
            startActivity(intent)
        }

    }


    fun ImageView.selected() {
        setBackgroundResource(R.drawable.bg_rounded)
        backgroundTintList = ContextCompat.getColorStateList(this@MainActivity, R.color.grey)
    }

    fun ImageView.unselected() {
        setBackgroundResource(R.drawable.bg_rounded)
        backgroundTintList = ContextCompat.getColorStateList(this@MainActivity, R.color.white)
    }

    override fun tampilkanHasil(result: String) {
        binding.tvResult.text = result
    }
}

