package com.ssu.xyvento.myblogapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.shashank.sony.fancytoastlib.FancyToast
import com.ssu.xyvento.myblogapp.databinding.ActivityRegisterScreenBinding

class Register_Screen_Activity : AppCompatActivity() {
    private  val binding: ActivityRegisterScreenBinding by lazy {
        ActivityRegisterScreenBinding.inflate(layoutInflater)
    }

    private  lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.loginOption.setOnClickListener {
            startActivity(Intent(this, Login_Screen_Activity::class.java))
            finish()
        }

        auth = FirebaseAuth.getInstance()

        binding.registerButton.setOnClickListener {
            var username = binding.usernameField.text.toString().trim()
            var emailid = binding.emailField.text.toString().trim()
            var password = binding.passwordField.text.toString().trim()
            var repeatpassword = binding.repeatPasswordField.text.toString().trim()

            if(username.isEmpty() || emailid.isEmpty()|| password.isEmpty() || repeatpassword.isEmpty()){
                FancyToast.makeText(this,
                    "input Field are Empty",
                    FancyToast.LENGTH_SHORT,
                    FancyToast.ERROR
                    , false).show()
            }else if(password !=repeatpassword){
                FancyToast.makeText(this,
                    "Password not Matched",
                    FancyToast.LENGTH_SHORT,
                    FancyToast.ERROR
                    , false).show()
            }else{
                auth.createUserWithEmailAndPassword(emailid, password)
                    .addOnCompleteListener {
                        task ->
                        if(task.isSuccessful){
                            FancyToast.makeText(this,
                                "Login SuccessFuLL",
                                FancyToast.LENGTH_SHORT,
                                FancyToast.SUCCESS
                                , false).show()
                            startActivity(Intent(this, Login_Screen_Activity::class.java))
                            finish()
                        }else{
                            FancyToast.makeText(this,
                                "Error${task.exception?.message}",
                                FancyToast.LENGTH_SHORT,
                                FancyToast.ERROR
                                , false).show()
                        }
                    }
            }
        }
    }
}