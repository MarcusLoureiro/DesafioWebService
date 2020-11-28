package com.example.desafiowebservice.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiowebservice.Adapters.HqAdapter
import com.example.desafiowebservice.R
import com.example.desafiowebservice.Service.service
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var hqAdapter: HqAdapter
    private lateinit var lManager: LinearLayoutManager

    private val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(service) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lManager = LinearLayoutManager(this)
        rvHqs.layoutManager = lManager

        hqAdapter = HqAdapter()
        rvHqs.adapter = hqAdapter

        viewModel.getAllResults()

        viewModel.listResult.observe(this){
                Log.i("Home", it.toString())
        }


//        viewModel.listResult.observe(this) {
//            hqAdapter.addHq(it)
//
//        }



    }
}
