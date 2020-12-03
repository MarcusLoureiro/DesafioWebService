package com.example.desafiowebservice.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservice.Adapters.ResAdapter
import com.example.desafiowebservice.Entities.SpiderMan.Res
import com.example.desafiowebservice.R
import com.example.desafiowebservice.Service.service
import kotlinx.android.synthetic.main.activity_home.*
import kotlin.math.log

class HomeActivity : AppCompatActivity(), ResAdapter.OnHqClickListener {
    private lateinit var hqAdapter: ResAdapter
    private lateinit var lManager: LinearLayoutManager
    private lateinit var listHqs: Res



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
        listHqs = Res()




        lManager = GridLayoutManager(this, 3)
        hqAdapter = ResAdapter(listHqs, this)
        rvHqs.layoutManager = lManager
        rvHqs.adapter = hqAdapter
        rvHqs.hasFixedSize()


        viewModel.listRes.observe ( this ) {
            hqAdapter.addHq (it)
            Log.i("Tag", it.toString())
        }

        viewModel.getAllResults()

        //setScroller ()
    }

    override fun onItemClick(position: Int) {
        viewModel.listRes.observe(this) {
            hqAdapter.addHq(it)
            Log.i("Tag click", it.toString())
            hqAdapter.notifyDataSetChanged()
        }

    }

//    fun setScroller() {
//        rvHqs.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                if (dy > 0) {
//                    val litem = lManager.itemCount
//                    val vItem = lManager.findFirstCompletelyVisibleItemPosition()
//                    val itens = hqAdapter.itemCount
//                    if (litem + vItem >= itens) {
//                        viewModel.getAllResults(page+1)
//                        page = page + 1
//                        Log.i("PAGE",  page.toString())
//                    }
//                }
//            }
//        })
//    }


}
