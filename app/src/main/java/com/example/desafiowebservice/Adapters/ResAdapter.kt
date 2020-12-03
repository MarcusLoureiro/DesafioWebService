package com.example.desafiowebservice.Adapters

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

class ResAdapter(val listHqs : Res, private val listener: OnHqClickListener):RecyclerView.Adapter<ResAdapter.ResViewHolder>() {



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
        val number = currentItem.issueNumber.toString()

        if (number.takeLast(1) == "0"){
            holder.number.text = "#${currentItem.issueNumber.toInt()}"
        }else
            holder.number.text = "#${currentItem.issueNumber}"

        holder.imgHQ.setOnClickListener {
            val intent = Intent(holder.itemView.context, HqSelectedActivity::class.java)
            var bundle = Bundle()
            if (img != null){
                bundle.putString("thumbnail", img)
            }else{
                bundle.putString("thumbnail", "Sem imagem disponível")
            }
            if (currentItem.title != null){
                bundle.putString("title", currentItem.title)
            }else{
                bundle.putString("title", "Sem título disponível")
            }
            if (currentItem.prices[0].price != null){
                bundle.putDouble("price", currentItem.prices[0].price)
            }else{
                bundle.putDouble("price", 0.0)
            }
            if (currentItem.dates[0].date != null){
                bundle.putString("date", currentItem.dates[0].date)
            }else{
                bundle.putString("date", "Sem data disponível")
            }
            if ( currentItem.description != null){
                bundle.putString("description", currentItem.description)
            }else{
                bundle.putString("description", "Sem descrição disponível")
            }
            if ( currentItem.pageCount != null){
                bundle.putInt("pages", currentItem.pageCount)
            }else{
                bundle.putInt("pages", 0)
            }
            if ( currentItem.issueNumber != null){
                bundle.putInt("number", currentItem.issueNumber.toInt())
            }else{
                bundle.putInt("number", 0)
            }
            if ( currentItem.variantDescription != null ){
                bundle.putString("variant", currentItem.variantDescription)
            }else{
                bundle.putString("variant", "Sem descrição de variante disponível")
            }

            intent.putExtras(bundle)
            holder.itemView.context.startActivity(intent)
            Log.i("TAG Bundle", bundle.toString())
            Log.i("TAG Item", currentItem.toString())
        }
    }

    override fun getItemCount() = listHqs.data.results.size

    inner class ResViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener  {
        val number = itemView.hq_nome
        val imgHQ = itemView.hq_thumb

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnHqClickListener {
        fun onItemClick(position: Int)
    }

    fun addHq(list: Res){
        listHqs.data.results.addAll(list.data.results)
        Log.i("TAG ADD", list.toString())
        notifyDataSetChanged()
    }

    fun clear(){
        listHqs.data.results.clear()
        notifyDataSetChanged()
    }

}