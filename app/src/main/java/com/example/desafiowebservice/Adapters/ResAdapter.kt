package com.example.desafiowebservice.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservice.Entities.SpiderMan.Res
import com.example.desafiowebservice.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_hq.view.*
import kotlinx.android.synthetic.main.fragment_hq_details.view.*

class ResAdapter():RecyclerView.Adapter<ResAdapter.ResViewHolder>() {

    val listHqs = ArrayList<Res>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResAdapter.ResViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_hq, parent, false)
        return ResViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResViewHolder, position: Int) {
        val hq = listHqs.get(position)
        val picasso = Picasso.get()
        val urlBase = "https://gateway.marvel.com/v1/public/"
        val pathImg = hq.data.results.get(position).images.get(position).path
        val extensionImg = hq.data.results.get(position).images.get(position).extension


        holder.title.text = hq.data.results.get(position).title
        picasso.load(urlBase +"${pathImg}.${extensionImg}").into(holder.imgHQ)
    }

    override fun getItemCount() = listHqs.size

    class ResViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title = itemView.tvTitulo
        val imgHQ = itemView.imgHq


    }

    fun addHq(list: Res){
        listHqs.addAll(listOf(list))
        notifyDataSetChanged()
    }

    fun clear(){
        listHqs.clear()
        notifyDataSetChanged()
    }

}