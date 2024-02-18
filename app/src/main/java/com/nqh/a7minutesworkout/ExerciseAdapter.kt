package com.nqh.a7minutesworkout

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nqh.a7minutesworkout.databinding.ItemExerciseStatusBinding

class ExerciseAdapter(val items: ArrayList<ExerciseModel>): RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {
    class ViewHolder(binding: ItemExerciseStatusBinding): RecyclerView.ViewHolder(binding.root) {
        val tvItem = binding.tvItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemExerciseStatusBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //gán ID cho tvItem
        val model: ExerciseModel = items[position]
        holder.tvItem.text = model.getId().toString()

        when{
            model.getSelected() -> {
                holder.tvItem.background = ContextCompat.getDrawable(holder.itemView.context,
                    R.drawable.item_circular_selected_background)
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
            model.getCompleted() -> {
                holder.tvItem.background = ContextCompat.getDrawable(holder.itemView.context,
                    R.drawable.item_circular_completed_background)
                holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))
            }
            else -> {
                holder.tvItem.background = ContextCompat.getDrawable(holder.itemView.context,
                    R.drawable.item_circular_gray_background)
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
        }
    }
}