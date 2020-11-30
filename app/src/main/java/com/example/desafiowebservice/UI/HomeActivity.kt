package com.example.desafiowebservice.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservice.Adapters.ResAdapter
import com.example.desafiowebservice.R
import com.example.desafiowebservice.Service.service
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var hqAdapter: ResAdapter
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
        hqAdapter = ResAdapter()
        rvHqs.layoutManager = lManager
        rvHqs.adapter = hqAdapter
        rvHqs.hasFixedSize()



        viewModel.listResult.observe(this) {
           hqAdapter.addHq(it)
        }

        viewModel.getAllResults()

        setScroller()
    }

    fun setScroller(){
        rvHqs.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy > 0){
                    val litem = lManager.itemCount
                    val vItem  = lManager.findFirstCompletelyVisibleItemPosition()
                    val itens = hqAdapter.itemCount
                    if(litem + vItem >= itens){
                        Log.i("TAG", "Chamou")
                    }
                }
            }
        })
    }
}
