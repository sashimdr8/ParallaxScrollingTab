package com.dms.main

import android.databinding.DataBindingUtil
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dms.R
import com.dms.databinding.ItemMainViewBinding
import com.dms.databinding.ItemMenuBinding

class MenuAdapter(val items: ArrayList<String>, val context: FragmentActivity?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    protected val TYPE_HEADER = 0
    protected val TYPE_CELL = 1

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            else -> TYPE_CELL
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View
        val mainBinding: ItemMainViewBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.context), R.layout.item_main_view,
                viewGroup, false)

        when (viewType) {
            TYPE_HEADER -> return ViewHolder(LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.hvp_header_placeholder, viewGroup, false))

            else -> return MainHolder(mainBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }


}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // Holds the TextView that will add each animal to
//    val tvAnimalType = binding.tv_animal_type
}

class MainHolder(binding: ItemMainViewBinding) : RecyclerView.ViewHolder(binding.root) {
    // Holds the TextView that will add each animal to
//    val tvAnimalType = binding.tv_animal_type
}