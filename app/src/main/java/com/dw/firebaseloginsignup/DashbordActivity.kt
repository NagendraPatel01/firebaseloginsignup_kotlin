package com.dw.firebaseloginsignup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class DashbordActivity : AppCompatActivity() {

    var recycle: RecyclerView? = null

    var adapter: RecycleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashbord)

        val button=findViewById<Button>(R.id.btn)
            recycle=findViewById(R.id.recycle);

        //github token= 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


        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycle?.setLayoutManager(linearLayoutManager)


        button.setOnClickListener {

            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@DashbordActivity, LoginActivity::class.java))
            Toast.makeText(this@DashbordActivity, "User logout succesfully", Toast.LENGTH_SHORT).show();
            finish()
        }

        val options = FirebaseRecyclerOptions.Builder<User>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("Users"), User::class.java)
            .build()

        adapter = RecycleAdapter(options)
        recycle?.setAdapter(adapter)

    }
    override fun onStart() {
        super.onStart()
        adapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter!!.stopListening()
    }
}