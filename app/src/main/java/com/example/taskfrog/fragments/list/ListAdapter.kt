package com.example.taskfrog.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskfrog.R
import com.example.taskfrog.room.FrogList

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var listOfLists = emptyList<FrogList>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listOfLists[position]
        holder.itemView.findViewById<TextView>(R.id.tv_listName).text = currentItem.list_name.toString()
    }

    override fun getItemCount(): Int {
        return listOfLists.size
    }

    fun setData(frogList: List<FrogList>){
        this.listOfLists = frogList
        notifyDataSetChanged()
    }

}