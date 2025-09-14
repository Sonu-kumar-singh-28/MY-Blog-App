package com.ssu.xyvento.myblogapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ssu.xyvento.myblogapp.databinding.ActivityWelcomePageBinding

class Welcome_page_Activity : AppCompatActivity() {

    private val binding: ActivityWelcomePageBinding by lazy {
        ActivityWelcomePageBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // get Started Button Done
        val getStartedButton = findViewById<Button>(R.id.btn_getstarted)
        getStartedButton.setOnClickListener {
             startActivity(Intent(this, Login_Screen_Activity::class.java))
            finish()
        }
    }
}