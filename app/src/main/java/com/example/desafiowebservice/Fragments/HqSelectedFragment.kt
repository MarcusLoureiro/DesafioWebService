package com.example.desafiowebservice.Fragments


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.desafiowebservice.R
import com.example.desafiowebservice.UI.HomeActivity
import com.example.desafiowebservice.UI.HqExpansiveActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_hq_details.view.*
import java.text.SimpleDateFormat
import java.util.*


class HqSelectedFragment(
    val title: String?,
    val description: String?,
    val thumbnail: String?,
    val price: Double,
    val date: String?,
    val pages: Int,
    val number: Int,
    val variant: String?) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val picasso = Picasso.get()
        var view = inflater.inflate(R.layout.fragment_hq_details, container, false)
        picasso.load(thumbnail).into(view.imgHqExpansive)
        picasso.load(thumbnail).into(view.img_fundo)
        view.tvTitulo.text = "${title} ${variant}"
        view.tvDetais.text = description
        view.tvData.text = setData(date)
        view.tvPrice.text = price.toString()
        view.tvPages.text = pages.toString()
        Log.i("TAG fragment", "${title}+${description}+${number}+${pages}+${variant}+${price}+${date}+${thumbnail}+")

        view.imgHqExpansive.setOnClickListener {
            val intent = Intent(activity, HqExpansiveActivity::class.java)
            intent.putExtra("img", thumbnail)
            startActivity(intent)
        }

        view.img_back.setOnClickListener {
            val intent = Intent(activity, HomeActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    fun setData(date: String?): String{
        var ano = "${date?.get(0)}${date?.get(1)}${date?.get(2)}${date?.get(3)}"
        var mes = "${date?.get(5)}${date?.get(6)}"
        var dia = "${date?.get(8)}${date?.get(9)}"
        if(mes == "01"){
            mes = "January"
        } else if(mes == "02"){
            mes = "February"
        }else if(mes == "03"){
            mes = "March"
        }else if(mes == "04"){
            mes = "April"
        }else if(mes == "05"){
            mes = "May"
        }else if(mes == "06"){
            mes = "June"
        }else if(mes == "07"){
            mes = "July"
        }else if(mes == "08"){
            mes = "August"
        }else if(mes == "09"){
            mes = "September"
        }else if(mes == "10"){
            mes = "October"
        }else if(mes == "11"){
            mes = "November"
        }else if(mes == "12"){
            mes = "December"
        }else
            mes = "Void"
        val data: String = "${mes} ${dia}, ${ano}"
        return data
    }

}