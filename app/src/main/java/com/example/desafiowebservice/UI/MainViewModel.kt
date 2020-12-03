package com.example.desafiowebservice.UI


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiowebservice.Entities.SpiderMan.Data
import com.example.desafiowebservice.Entities.SpiderMan.Res
import com.example.desafiowebservice.Entities.SpiderMan.Results
import com.example.desafiowebservice.Service.Service
import kotlinx.coroutines.launch

class MainViewModel(val service: Service) : ViewModel() {


    var listRes = MutableLiveData<Res>()


    fun getAllResults(){
        viewModelScope.launch {
            listRes.value = service.getAllResults(
                0,
                20,
                "1",
                "6eb7e8896ec5850c52515a8a23ee97f0",
                "40a3aa568bb269dfad85ae0c4a297181"
            )

        }


    }

}
