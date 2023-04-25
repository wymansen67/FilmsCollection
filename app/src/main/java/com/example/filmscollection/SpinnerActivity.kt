package com.example.filmscollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

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

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(applicationContext, "Ты Че Не Выбрал?", Toast.LENGTH_LONG).show()
    }
}