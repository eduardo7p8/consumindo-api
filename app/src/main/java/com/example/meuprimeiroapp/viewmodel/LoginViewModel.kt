package com.example.meuprimeiroapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.meuprimeiroapp.R
import com.example.meuprimeiroapp.domain.LoginData
import com.example.meuprimeiroapp.domain.LoginResult
import com.example.meuprimeiroapp.interactor.LoginInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginViewModel(val app: Application) : AndroidViewModel(app), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main



    val interactor = LoginInteractor()
    val resultadoParaTela =  MutableLiveData<LoginResult>()

    fun login(data: LoginData) {

        var textoMensagemTela: String = ""

        launch {
            val resultado = interactor.login(data)
            if (resultado.error != null) {
                if (resultado.error == "ERRO_EMAIL_VAZIO") {
                    resultado.error = app.getString(R.string.email_required)
                } else if (resultado.error == "ERRO_SENHA_VAZIA") {
                    resultado.error = app.getString(R.string.pass_required)
                } else if (resultado.error == "ERRO_SENHA_MENOR_QUE_6") {
                    resultado.error = app.getString(R.string.pass_min_seis)
                } else if (resultado.error == "LOGIN_FIREBASE_ERRO") {
                    resultado.error = app.getString(R.string.error_login)
                }

            } else {
                resultado.error = null
                resultado.result = app.getString(R.string.sucesso_login)
            }
            resultadoParaTela.value = resultado
        }

    }


}