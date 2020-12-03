package com.example.desafiowebservice.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.desafiowebservice.Fragments.HqSelectedFragment
import com.example.desafiowebservice.R
import com.example.desafiowebservice.Adapters.ViewPagerHomeAdapter
import com.example.desafiowebservice.Entities.SpiderMan.Results
import kotlinx.android.synthetic.main.activity_hq_selected.*

class HqSelectedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hq_selected)

        setFragment()


    }
    private  fun  setFragment () {
        val bundle = intent.extras
        val adapter =  ViewPagerHomeAdapter (supportFragmentManager)
        if (bundle !=  null ) {
            val title = bundle.getString ( "title" )
            val price = bundle.getDouble ( "price" )
            val thumbnail = bundle.getString ( "thumbnail" )
            val date = bundle.getString ( "date" )
            val description = bundle.getString ( "description" )
            val pages = bundle.getInt ( "pages" )
            val number = bundle.getInt ( "number" )
            val variant = bundle.getString ( "variant" )
            Log.i("TAG setfragment", bundle.toString())
            adapter.addFragment ( HqSelectedFragment (title, description, thumbnail, price, date, pages, number, variant), " HQ " )
            Log.i(
                "TAG setfragment2",
                "${title}, ${description}, ${thumbnail}, ${price}, ${date}, ${pages}, ${number}, ${variant}"
            )
            viewPager_HomePage.adapter = adapter
        }
    }
//    private fun setFragment(){
//        val hqAtualTitle = intent.getSerializableExtra("title") as? Results
//        val hqAtualNumber = intent.getSerializableExtra("number") as? Results
//        val hqAtualThumb = intent.getSerializableExtra("thumb") as? Results
//        val hqAtualDescription = intent.getSerializableExtra("description") as? Results
//        val hqAtualPage = intent.getSerializableExtra("page") as? Results
//        val hqAtualPrices = intent.getSerializableExtra("prices") as? Results
//        val hqAtualDates = intent.getSerializableExtra("dates") as? Results
//
//        val adapter = ViewPagerHomeAdapter(supportFragmentManager)
//            val title = hqAtualTitle.toString()
//            val number = hqAtualNumber.toString()
//            val thumbnail = hqAtualThumb.toString()
//            val description = hqAtualDescription.toString()
//            val pages = hqAtualPage.toString().toInt()
//            val price = hqAtualPrices.toString().toDouble()
//            val date = hqAtualDates.toString()
//            adapter.addFragment(HqSelectedFragment(title, description, thumbnail, price, date, pages, number), "HQ")
//            viewPager_HomePage.adapter = adapter
//        }
    }
