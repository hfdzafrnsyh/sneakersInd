package com.example.sneakersind.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sneakersind.R
import com.example.sneakersind.`class`.Shoes

class ShoesListAdapter (private val listShoes : ArrayList<Shoes>): RecyclerView.Adapter<ShoesListAdapter.ListShoesViewHolder>() {




    private lateinit var onItemClickCallBack : OnItemClickCallBack



    fun setOnClickCallBack(onClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onClickCallBack
    }



    interface OnItemClickCallBack {
        fun onItemCliked( data : Shoes)
    }



    inner class ListShoesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name : TextView = itemView.findViewById(R.id.tv_item_name)
        val detail : TextView = itemView.findViewById(R.id.tv_item_detail)
        val image : ImageView = itemView.findViewById(R.id.img_shoes_photo)

    }



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListShoesViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_shoes, viewGroup, false)
        return ListShoesViewHolder(view)
    }




    override fun onBindViewHolder(holder: ListShoesViewHolder, i: Int) {
        val shoes = listShoes[i]
        Glide.with(holder.itemView.context)
            .load(shoes.image)
            .apply(RequestOptions().override(55, 55))
            .into(holder.image)

        holder.name.text = shoes.name
        holder.detail.text = shoes.detail

        holder.itemView.setOnClickListener{
            onItemClickCallBack.onItemCliked(listShoes[holder.adapterPosition])
        }
    }


    override fun getItemCount(): Int {
        return listShoes.size
    }












}