package com.nqh.a7minutesworkout.adapter

import android.content.Context
import android.graphics.Color
import android.text.Layout
import android.view.ContentInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nqh.a7minutesworkout.Database.HistoryEntity
import com.nqh.a7minutesworkout.R
import com.nqh.a7minutesworkout.databinding.ItemHistoryBinding

class HistoryAdapter(
    private val context: Context,
    private val listDates: ArrayList<HistoryEntity>
) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val llHistoryItemMain: LinearLayout = view.findViewById(R.id.ll_history_item_main)
        val tvPosition: TextView = view.findViewById(R.id.tvPosition)
        val tvItemDate: TextView = view.findViewById(R.id.tvItemDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return ViewHolder(view)
//        return ViewHolder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listDates.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = listDates[position]
        holder.tvItemDate.text = item.date
        holder.tvPosition.text = (position+1).toString()


        //color
        if (position % 2 == 0) {
            holder.llHistoryItemMain.setBackgroundColor(Color.parseColor("#EBEBEB"))
        } else {
            holder.llHistoryItemMain.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }
}