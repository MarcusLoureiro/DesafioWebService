package com.example.desafiowebservice.Adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservice.Entities.SpiderMan.Res
import com.example.desafiowebservice.R
import com.example.desafiowebservice.UI.HqSelectedActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_hq.view.*
import kotlinx.android.synthetic.main.fragment_hq_details.view.*

class ResAdapter(val listHqs : Res):RecyclerView.Adapter<ResAdapter.ResViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResAdapter.ResViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_hq, parent, false)
        return ResViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResViewHolder, position: Int) {
        val currentItem = listHqs.data.results[position]
        val picasso = Picasso.get()
        val pathImg = currentItem.thumbnail.path
        val extensionImg = currentItem.thumbnail.extension
        val img = "${pathImg}.${extensionImg}".replace("http://","https://")
        picasso.load(img).into(holder.imgHQ)
        holder.number.text = currentItem.issueNumber.toString()
        holder.imgHQ.setOnClickListener {
            val intent = Intent(holder.itemView.context, HqSelectedActivity::class.java)
            var bundle = Bundle()
            bundle.putString("thumbnail", img)
            bundle.putString("title", currentItem.title)
            bundle.putDouble("price", currentItem.prices[position].price)
            bundle.putString("date", currentItem.dates[position].date)
            bundle.putString("description", currentItem.description)
            bundle.putInt("pages", currentItem.pageCount)
            bundle.putInt("number", currentItem.issueNumber)
            bundle.putInt("number", currentItem.issueNumber)
            bundle.putString("variant", currentItem.variantDescription)
            intent.putExtras(bundle)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listHqs.data.results.size

    class ResViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val number = itemView.tvTitulo
        val imgHQ = itemView.imgHq


    }

    fun addHq(list: Res){
        listHqs.data.results.addAll(list.data.results)
        notifyDataSetChanged()
    }

    fun clear(){
        listHqs.data.results.clear()
        notifyDataSetChanged()
    }

}