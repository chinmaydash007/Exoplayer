package com.example.recyclerviewwithkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithkotlin.Adapter.MyAdapter
import com.example.recyclerviewwithkotlin.Model.Person
import com.example.recyclerviewwithkotlin.Model.persons
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MyAdapter.OnPersonClick {
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
        myAdapter = MyAdapter(list, this,this)
        recylclerView.adapter = myAdapter
        recylclerView.addItemDecoration(DividerItemDecoration(recylclerView.context,linearLayoutManager.orientation))

    }

    override fun onPersonClick(position: Int) {
        showToast(position.toString())
        var intent= Intent(this@MainActivity,Main2Activity::class.java)
        intent.putExtra("person",list.get(position))
        startActivity(intent)
    }
}
