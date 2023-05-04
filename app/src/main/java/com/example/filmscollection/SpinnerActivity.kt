package com.example.filmscollection

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.filmscollection.databinding.ActivityMainBinding
import com.example.filmscollection.databinding.ActivitySpinnerBinding
import com.google.gson.Gson

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var bindingClass : ActivitySpinnerBinding
    public var sharedChoice: String = ""
    private var spinner: Spinner? = null
    private var arrayAdapter:ArrayAdapter<String>? = null
    var items:String = ""

    private var itemlist = arrayOf("Комедия", "Драма", "Боевик", "Милодрама", "Ужасы", "Детектив", "Мультфильм")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        spinner = findViewById(R.id.spinners)
        arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, itemlist)
        spinner?.adapter = arrayAdapter
        spinner?.onItemSelectedListener = this

        bindingClass.batonblin.setOnClickListener{
            val nameG = items.toString()
            val js:String = Gson().toJson(nameG)
            intent.putExtra("genre", js)

            val intent = Intent(this@SpinnerActivity,MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var items:String = parent?.getItemAtPosition(position) as String
        Toast.makeText(applicationContext, "$items", Toast.LENGTH_LONG).show()
            sharedChoice = parent?.getItemAtPosition(position) as String
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(applicationContext, "Ты Че Не Выбрал, М??", Toast.LENGTH_LONG).show()
    }
}