package com.example.finalproject.presentation.first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.R
import com.example.finalproject.data.CatDataClass

class CustomAdapter(val listener: Listener) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val myListOfAnimals = ArrayList<CatDataClass>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detal)
        }

    }

    fun setArrayListOfMyAnimals(listOfAnimal: ArrayList<CatDataClass>) {
        this.myListOfAnimals.clear()
        this.myListOfAnimals.addAll(listOfAnimal)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        val animal = myListOfAnimals[i]
        viewHolder.itemView.setOnClickListener {
            listener.onClick(i)
        }
        Glide.with(viewHolder.itemView.context)
            .load(myListOfAnimals.get(i).URL).fitCenter().into(viewHolder.itemImage)
        viewHolder.itemDetail.text = animal.titles
        viewHolder.itemTitle.text = animal.details

    }


    override fun getItemCount(): Int {
        return myListOfAnimals.size
    }

    interface Listener {
        fun onClick(itemView: Int)
    }

}