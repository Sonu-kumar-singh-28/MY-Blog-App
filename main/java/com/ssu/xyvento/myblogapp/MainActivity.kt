package com.ssu.xyvento.myblogapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ssu.xyvento.myblogapp.databinding.ActivityLoginScreenBinding
import com.ssu.xyvento.myblogapp.databinding.ActivitySplashScreenBinding

class MainActivity : AppCompatActivity() {
    private  val binding: ActivityLoginScreenBinding by lazy {
        ActivityLoginScreenBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

    }
}