package com.dw.firebaseloginsignup

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class RecycleAdapter(@NonNull options: FirebaseRecyclerOptions<User?>?) :
    FirebaseRecyclerAdapter<User, RecycleAdapter.ViewHolder>(options!!) {


    public override fun onBindViewHolder(
        @NonNull holder: ViewHolder,
        @SuppressLint("RecyclerView") position: Int,
        @NonNull user: User
    ) {
        holder.text1.setText(user.useremail)
        holder.text2.setText(user.userpassword)

    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.recycle, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text1: TextView
        var text2: TextView



        init {
            text1 = itemView.findViewById(R.id.text1)
            text2 = itemView.findViewById(R.id.text2)

        }
    }
}