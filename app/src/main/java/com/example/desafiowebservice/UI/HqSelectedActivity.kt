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


        val adapter = ViewPagerHomeAdapter(supportFragmentManager)
        adapter.addFragment(HqSelectedFragment(), "HQ")
        viewPager_HomePage.adapter = adapter
    }
}