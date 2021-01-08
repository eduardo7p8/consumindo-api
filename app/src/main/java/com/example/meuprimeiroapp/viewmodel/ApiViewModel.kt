package com.example.meuprimeiroapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.meuprimeiroapp.domain.Personagen
import com.example.meuprimeiroapp.interactor.ApiInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class ApiViewModel(val app: Application) : AndroidViewModel(app), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

             private val interactor = ApiInteractor()
              val resultadoParaTela = MutableLiveData<List<Personagen>>()
         fun chamarAPI(){
             launch {
              val listaPersonagens =  interactor.chamarAPI()
                 resultadoParaTela.value = listaPersonagens
             }

         }
}