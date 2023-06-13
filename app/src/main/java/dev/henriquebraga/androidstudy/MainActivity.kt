package dev.henriquebraga.androidstudy

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AlertDialog
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

            val name = binding.textEdit1.text.toString()

            if(TextUtils.isEmpty(name)) {
                showAlert("Insert an name!")
            }
            else {
                binding.textLabel1.text = "$name, You've pressed the button!!"
            }

        }
    }

    private fun showAlert(message: String) {
        val builder = AlertDialog.Builder(this)
        .setTitle("Alert")
        .setMessage(message)
            .setPositiveButton("ok") {_, _ ->
            }
        builder.show()
    }

}