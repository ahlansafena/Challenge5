package com.example.ahlangame.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.ahlangame.R
import com.example.ahlangame.databinding.FragmentPage3Binding
import kotlin.math.log

class Page3Fragment : Fragment() {

    private lateinit var binding: FragmentPage3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPage3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etNama.addTextChangedListener {
            if (it.toString().length > 0) {
                binding.btnMenu.visibility = View.VISIBLE
            } else {
                binding.btnMenu.visibility =View.GONE
            }
        }
        binding.btnMenu.setOnClickListener {
        Intent(requireActivity(), MainActivity5::class.java).apply {
            putExtra("data", binding.etNama.text.toString())
            startActivity(this)

        }
        }

    }
}
