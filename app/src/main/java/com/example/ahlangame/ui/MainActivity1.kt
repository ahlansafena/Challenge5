package com.example.ahlangame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ahlangame.databinding.ActivityMain1Binding
import com.example.ahlangame.databinding.ActivityMain2Binding

class MainActivity1 : AppCompatActivity() {
    lateinit var binding: ActivityMain1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val listFragment = mutableListOf(Page1Fragment(), Page2Fragment(), Page3Fragment())
        val adapterViewPager2 = AdapterViewPager2(this, listFragment)
        binding.viewpager2.adapter = adapterViewPager2
        binding.springDotsIndicator.attachTo(binding.viewpager2)
    }
}