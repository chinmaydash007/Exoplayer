package com.example.recyclerviewwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithkotlin.Adapter.MyAdapter
import com.example.recyclerviewwithkotlin.Model.Person
import com.example.recyclerviewwithkotlin.Model.persons
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var list: ArrayList<Person>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = ArrayList()
        list.addAll(persons.persons)

        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recylclerView.layoutManager = linearLayoutManager
        myAdapter = MyAdapter(list, this)
        recylclerView.adapter = myAdapter
    }
}
