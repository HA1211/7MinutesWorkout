package com.nqh.a7minutesworkout.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nqh.a7minutesworkout.Database.HistoryEntity
import com.nqh.a7minutesworkout.databinding.ItemHistoryBinding

class HistoryAdapter
    (private val context: Context,
     private val items: ArrayList<HistoryEntity>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        val llHistoryItemMain = binding.llHistoryItemMain
        val tvPosition = binding.tvPosition
        val tvItemDate = binding.tvItemDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]
        holder.tvPosition.text = (position + 1).toString()
        holder.tvItemDate.text = item.date

        //color
        if (position % 2 == 0) {
            holder.llHistoryItemMain.setBackgroundColor(Color.parseColor("#EBEBEB"))
        } else {
            holder.llHistoryItemMain.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }
}