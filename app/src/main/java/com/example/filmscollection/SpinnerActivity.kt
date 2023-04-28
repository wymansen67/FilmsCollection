package com.example.filmscollection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    public var sharedChoice: String = ""
    private var spinner: Spinner? = null
    private var arrayAdapter:ArrayAdapter<String>? = null

    private var itemlist = arrayOf("Комедия", "Драма", "Боевик", "Милодрама", "Ужасы", "Детектив", "Мультфильм")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        spinner = findViewById(R.id.spinners)
        arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, itemlist)
        spinner?.adapter = arrayAdapter
        spinner?.onItemSelectedListener = this
    }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var items:String = parent?.getItemAtPosition(position) as String
        Toast.makeText(applicationContext, "$items", Toast.LENGTH_LONG).show()
            sharedChoice = parent?.getItemAtPosition(position) as String

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(applicationContext, "Ты Че Не Выбрал, М??", Toast.LENGTH_LONG).show()
    }

    fun handler() {
        val intent = Intent(this@SpinnerActivity,GeneralActivity::class.java)
        startActivity(intent)
        finish()
    }
}