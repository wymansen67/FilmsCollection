package com.example.filmscollection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmscollection.databinding.ActivityMain2Binding
import com.google.gson.Gson

class MainActivity2 : AppCompatActivity() {
    lateinit var bindingClass: ActivityMain2Binding
    lateinit var filmnmae:String
    lateinit var releasedate:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val nameG: String = intent.getStringExtra("genre").toString()
        bindingClass.filmGenre.setText(nameG)

        bindingClass.batonblin.setOnClickListener{
            filmnmae = bindingClass.filmName.toString()

            releasedate = bindingClass.releaseDate.toString()

            val js:String = Gson().toJson(filmnmae)
            intent.putExtra("filmnmae", js)

            val jss:String = Gson().toJson(releasedate)
            intent.putExtra("releasedate", jss)
        }
    }
}