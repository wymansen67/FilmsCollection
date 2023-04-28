
package com.example.filmscollection

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.filmscollection.databinding.ActivityMainBinding
import java.io.FileOutputStream

class GeneralActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding
    lateinit var filmName: EditText
    lateinit var releaseDate: EditText
    lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general)
    }

    fun handler() {
        //FileOutputStream()
    }
}