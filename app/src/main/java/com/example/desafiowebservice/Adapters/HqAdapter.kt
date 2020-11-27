package com.example.desafiowebservice.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservice.Models.Hq
import com.example.desafiowebservice.R
import com.squareup.picasso.Picasso

class HqAdapter():RecyclerView.Adapter<HqAdapter.HqViewHolder>() {
    val listHqs = ArrayList<Hq>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HqAdapter.HqViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_hq, parent, false)
        return HqViewHolder(view)
    }

    override fun onBindViewHolder(holder: HqViewHolder, position: Int) {
        val picasso = Picasso.get()
        val urlBase = "https://promoios.com.br/"
        val currentItem = listHqs[position]



        val hq = listHqs.get(position)
//        holder.tvNomeProd.text = produto.nome_prod
//        holder.tvNomeEmp.text = produto.nome_emp
//        holder.tvData.text = produto.dt_exp
//        holder.tvValor.text = produto.valor
//        holder.tvVolProd.text = produto.vol_prod
//        picasso.load(urlBase +"img/produtos/" +currentItem.url).into(holder.imgUrl)
//        picasso.load(urlBase +"img/produtos/" +currentItem.url).into(holder.imgLogo)
    }

    override fun getItemCount() = listHqs.size

    class HqViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        val tvNomeProd: TextView = itemView.findViewById(R.id.tv_nome_prod)
//        val tvNomeEmp: TextView = itemView.findViewById(R.id.tv_nome_emp)
//        val tvData: TextView = itemView.findViewById(R.id.tv_dt_exp)
//        val tvValor: TextView = itemView.findViewById(R.id.tv_valor)
//        val tvVolProd: TextView = itemView.findViewById(R.id.tv_vol_prod)
//        val imgUrl: ImageView = itemView.findViewById(R.id.iv_url)
//        val imgLogo: ImageView = itemView.findViewById(R.id.iv_logo_emp)

    }

    fun addHq(itens: ArrayList<Hq>){
        listHqs.addAll(itens)
        notifyDataSetChanged()
    }

    fun clear(){
        listHqs.clear()
        notifyDataSetChanged()
    }

}