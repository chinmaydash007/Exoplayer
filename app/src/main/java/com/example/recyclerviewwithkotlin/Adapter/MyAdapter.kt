package com.example.recyclerviewwithkotlin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewwithkotlin.Model.Person
import com.example.recyclerviewwithkotlin.R
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.single_card_view.view.*

class MyAdapter(var list: List<Person>, var context: Context) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.single_card_view, parent, false);
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = list.get(position).name
        Glide.with(context).load(list.get(position).imageUrl).into(holder.imageView)

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.name
        var imageView:CircleImageView=itemView.profile_image
    }

}