package com.example.desafiowebservice.Fragments



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.desafiowebservice.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_hq_details.view.*
import kotlinx.android.synthetic.main.fragment_img_expansive.*



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
        view.tvTitulo.text = "${title} + ${number} + ${variant}"
        view.tvDetais.text = description
        view.tvData.text = date
        view.tvPrice.text = price.toString()
        view.tvPages.text = pages.toString()

        view.imgHqExpansive.setOnClickListener {
            view = inflater.inflate(R.layout.fragment_img_expansive, container, false)
            toolbarImage.setNavigationOnClickListener {
                view = inflater.inflate(R.layout.fragment_hq_details, container, false)
            }
        }
        return view
    }


}