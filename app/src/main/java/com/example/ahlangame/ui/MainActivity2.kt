package com.example.ahlangame.ui

import Callback
import Controller
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.ahlangame.R
import com.example.ahlangame.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity(), Callback {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnPemain1 = arrayOf(
            binding.btnA,
            binding.btnB,
            binding.btnC,
        )
        val btnPemain2 = arrayOf(
            binding.btnD,
            binding.btnE,
            binding.btnF,
        )
        val controller = Controller(this)
        var pemain1 = ""
        var pemain2 = ""


        btnPemain1.forEach { imageView ->
            imageView.setOnClickListener {
                imageView.selected()
                pemain1 = imageView.contentDescription.toString().lowercase()
                binding.btnA.isEnabled = false
                binding.btnB.isEnabled = false
                binding.btnC.isEnabled = false
            }
        }
        btnPemain2.forEach { imageView ->
            imageView.setOnClickListener {
                imageView.selected()
                pemain2 = imageView.contentDescription.toString().lowercase()
                controller.banding(pemain1, pemain2)
                binding.btnD.isEnabled = false
                binding.btnE.isEnabled = false
                binding.btnF.isEnabled = false
            }
        }

        binding.btnG.setOnClickListener {
            binding.tvHasil.text = "VS"
            btnPemain1.forEach { it.unselected() }
            btnPemain2.forEach { it.unselected() }
            binding.btnA.isEnabled = true
            binding.btnB.isEnabled = true
            binding.btnC.isEnabled = true
            binding.btnD.isEnabled = true
            binding.btnE.isEnabled = true
            binding.btnF.isEnabled = true
            binding.tvHasil.setBackgroundResource(R.drawable.bg_rounded)
        }

        binding.menuPemain.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }

    }


    fun ImageView.selected() {
        setBackgroundResource(R.drawable.bg_rounded)
        backgroundTintList = ContextCompat.getColorStateList(this@MainActivity2, R.color.grey)
    }

    fun ImageView.unselected() {
        setBackgroundResource(R.drawable.bg_rounded)
        backgroundTintList = ContextCompat.getColorStateList(this@MainActivity2, R.color.white)
    }

    override fun tampilkanHasil(result: String) {
        binding.tvHasil.text = result
        binding.tvHasil.setBackgroundResource(R.drawable.bg_txt)
    }
}