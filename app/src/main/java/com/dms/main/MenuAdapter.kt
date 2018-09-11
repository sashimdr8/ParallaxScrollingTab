package com.dms.main

import android.databinding.DataBindingUtil
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.dms.R
import com.dms.data.model.Article
import com.dms.databinding.ItemMainViewBinding
import com.dms.databinding.ItemMenuBinding

class MenuAdapter(val items: List<Article>, val context: FragmentActivity?) : RecyclerView.Adapter<MainHolder>() {


    protected val TYPE_HEADER = 0
    protected val TYPE_CELL = 1

//    override fun getItemViewType(position: Int): Int {
//        return when (position) {
//            0 -> TYPE_HEADER
//            else -> TYPE_CELL
//        }
//    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MainHolder {
        val mainBinding: ItemMainViewBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.context), R.layout.item_main_view,
                viewGroup, false)

        return MainHolder(mainBinding)
    }


    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.binding.tvAuthor.text = items[position].author
        holder.binding.tvTitle.text = items[position].title
        Glide.with(context)
                .load(items[position].urlToImage)
                .into(holder.binding.iv)
    }


}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // Holds the TextView that will add each animal to
//    val tvAnimalType = binding.tv_animal_type
}

class MainHolder(var binding: ItemMainViewBinding) : RecyclerView.ViewHolder(binding.root) {
    // Holds the TextView that will add each animal to
//    val tvAnimalType = binding.tv_animal_type
}