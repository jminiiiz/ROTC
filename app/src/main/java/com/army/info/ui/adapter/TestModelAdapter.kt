package com.army.info.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.army.info.R
import com.army.info.data.TestModel
import com.army.info.ui.activity.TestActivity

class TestModelAdapter(private val items: List<TestModel>) : RecyclerView.Adapter<TestModelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, TestActivity::class.java)
            intent.putExtra("data", item)
            holder.itemView.context.startActivity(intent)
        }
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val indexTextView: TextView = view.findViewById(R.id.textViewIndex)
        private val questionTextView: TextView = view.findViewById(R.id.textViewQuestion)

        fun bind(item: TestModel) {
            indexTextView.text = "${item.index}번"
            questionTextView.text = item.question
        }
    }
}
