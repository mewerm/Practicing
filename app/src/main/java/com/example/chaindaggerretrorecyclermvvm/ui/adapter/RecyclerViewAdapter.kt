package com.example.chaindaggerretrorecyclermvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.chaindaggerretrorecyclermvvm.R
import com.example.chaindaggerretrorecyclermvvm.model.RecyclerData
import kotlinx.android.synthetic.main.recycler_view_list_row.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

     private var listData: List<RecyclerData>? = null

    fun setUpdateData(listData: List<RecyclerData>){
        this.listData = listData

    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView = view.imageView
        private val textViewName = view.textViewName
        private val textViewDescription = view.textViewDescription

        fun bind(data: RecyclerData) {
            textViewName.text = data.name
            textViewDescription.text = data.description
            Glide.with(imageView)
                .load(data.owner?.avatar_url)
                .apply(RequestOptions.centerCropTransform())
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        listData?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {

        if(listData == null) return 0
        else return listData?.size!!

    }
}