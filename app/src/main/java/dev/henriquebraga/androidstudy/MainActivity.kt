package dev.henriquebraga.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.henriquebraga.androidstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // variable to control the binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActionListeners()
    }

    private fun setupActionListeners() {
        binding.button1.setOnClickListener {
            binding.textLabel1.text = "You've pressed the button!!"
        }
    }




}