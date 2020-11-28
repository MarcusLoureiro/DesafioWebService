package com.example.desafiowebservice.UI


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiowebservice.Entities.Hq
import com.example.desafiowebservice.Entities.SpiderMan.Characters
import com.example.desafiowebservice.Entities.SpiderMan.Data
import com.example.desafiowebservice.Entities.SpiderMan.Results
import com.example.desafiowebservice.Service.Service
import kotlinx.coroutines.launch

class MainViewModel (val service: Service) : ViewModel() {
    var listResult = MutableLiveData<Results>()


    fun getListRepo() {
        viewModelScope.launch {
        }
    }

    fun getAllResults(){
        viewModelScope.launch {
        listResult.value = service.getAllResults()
        }
    }


}
