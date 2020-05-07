package com.igao.lifecycleapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.igao.lifecycleapp.model.Job

class MainAdapter constructor(
    private val list: List<Job>,
    private val context: Context,
    private val listener: InteractionAdapter
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_job, parent, false),
            listener
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(list[position]) {
            holder.name.text = this.name
            holder.description.text = this.description
        }
    }

    inner class ViewHolder(itemView: View, internal val listener: InteractionAdapter) :
        RecyclerView.ViewHolder(itemView), View.OnLongClickListener {
        internal val name: TextView = itemView.findViewById(R.id.item_name)
        internal val description: TextView = itemView.findViewById(R.id.item_description)

        init {
            itemView.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            listener?.onInteractonAdapter(list[adapterPosition])
            return true
        }
    }


    interface InteractionAdapter {
        fun onInteractonAdapter(job: Job)
    }
}