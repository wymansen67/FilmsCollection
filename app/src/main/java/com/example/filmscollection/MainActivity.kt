package com.example.filmscollection

import android.app.AlertDialog
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.filmscollection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding
    lateinit var login: EditText
    lateinit var pass: EditText
    lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        login = bindingClass.login
        pass = bindingClass.pass
    }

    fun saving() {
        pref = getPreferences(MODE_PRIVATE)
        val ed = pref.edit()
        ed.putString("login", login!!.text.toString())
        ed.putString("pass", pass!!.text.toString())
        ed.apply()
    }

    fun handler(v: View) {
        if (v.id == R.id.signin) {
            if (login.getText().toString().trim().length > 0 && pass.getText().toString().trim().length > 0) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Хотите сохранить данные для следующих входов?")
                builder.setTitle("Сохранение данных")
                builder.setCancelable(false)
                builder.setPositiveButton("Yes") { dialog, which ->
                    saving()
                }
                builder.setNegativeButton("No") { dialog, which ->
                    dialog.cancel()
                }
                val alertDialog = builder.create()
                alertDialog.show()
            }
            else Toast.makeText(this, "Поля не должны быть пустыми", Toast.LENGTH_SHORT).show()
        }
        if (v.id == R.id.load) {
            pref = getPreferences(MODE_PRIVATE)
            login!!.setText(pref.getString("login", ""))
            pass!!.setText(pref.getString("pass", ""))

        }
    }
}