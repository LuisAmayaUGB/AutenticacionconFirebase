package com.example.fireapp5

import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dbReference: DatabaseReference
    private lateinit var firebaseDatabase: FirebaseDatabase



    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //    insert2database("dato1", "dato2")

        title="Welcome"
        auth = FirebaseAuth.getInstance()

        val anim = AnimationUtils.loadAnimation(this, R.anim.cae)
        imageView.startAnimation(anim)

        anim.setDuration(3000);
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.setRepeatMode(ValueAnimator.REVERSE);
    }


    fun signOut(view: View) {
        auth.signOut()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }




    fun insert2database(nombre: String, apellidos: String) {
        val student = HashMap<String, String>()
        student["Name"] = nombre
        student["Lat"] = apellidos.toString()
        student["Long"] = nombre.toString()
        student["Phone"] = "78787500000"
        val rootRef = FirebaseDatabase.getInstance().reference
        val tasksRef = rootRef.child("Alumnos").push()
        tasksRef.setValue(student)
    }














    fun onAnimationStart(animation:Animation) {}
    fun onAnimationEnd(animation1:Animation) {}
    fun onAnimationRepeat(animation: Animation) {}


}