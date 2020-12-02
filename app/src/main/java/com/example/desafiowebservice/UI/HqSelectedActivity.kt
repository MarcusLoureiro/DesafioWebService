package com.example.desafiowebservice.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiowebservice.Fragments.HqSelectedFragment
import com.example.desafiowebservice.R
import com.example.desafiowebservice.Adapters.ViewPagerHomeAdapter
import kotlinx.android.synthetic.main.activity_hq_selected.*

class HqSelectedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hq_selected)

        setFragment()
    }


    private fun setFragment(){
        val bundle = intent.extras
        val adapter = ViewPagerHomeAdapter(supportFragmentManager)
        if (bundle != null) {
            val title = bundle.getString("title")
            val price = bundle.getDouble("price")
            val thumbnail = bundle.getString("thumbnail")
            val date = bundle.getString("date")
            val description = bundle.getString("description")
            val pages = bundle.getInt("pages")
            val number = bundle.getInt("number")
            val variant = bundle.getString("variant")
            adapter.addFragment(HqSelectedFragment(title, description, thumbnail, price, date, pages, number, variant), "HQ")
            viewPager_HomePage.adapter = adapter
        }
    }
}