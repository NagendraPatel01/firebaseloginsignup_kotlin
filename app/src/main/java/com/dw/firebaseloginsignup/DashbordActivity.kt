package com.dw.firebaseloginsignup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class DashbordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashbord)

        val button=findViewById<Button>(R.id.btn)

        button.setOnClickListener {

            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@DashbordActivity, LoginActivity::class.java))
            Toast.makeText(this@DashbordActivity, "User logout succesfully", Toast.LENGTH_SHORT).show();
            finish()
        }

    }
}