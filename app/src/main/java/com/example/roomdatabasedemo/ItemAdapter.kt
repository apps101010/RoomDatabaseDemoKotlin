package com.example.roomdatabasedemo

import android.animation.ValueAnimator.AnimatorUpdateListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasedemo.databinding.ItemsRowBinding

class ItemAdapter(private val items: ArrayList<EmployeeEntity>,private val updateListener:(id:Int)->Unit,private val deleteListener:(id:Int)->Unit): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemsRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
      return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        val item = items[position]
        holder.tvName.text = item.name
        holder.tvEmail.text = item.email

        if (position % 2 == 0){
            holder.llMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.lightGray))
        }else{
            holder.llMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.white))
        }

        holder.tvEdit.setOnClickListener {
            updateListener.invoke(item.id)
        }

        holder.tvDelete.setOnClickListener {
            deleteListener.invoke(item.id )
        }
    }

    class ViewHolder(binding:ItemsRowBinding): RecyclerView.ViewHolder(binding.root){
        val llMain = binding.llMain
        val tvName = binding.tvName
        val tvEmail = binding.tvEmail
        val tvEdit = binding.ivEdit
        val tvDelete = binding.ivDelete

    }

}