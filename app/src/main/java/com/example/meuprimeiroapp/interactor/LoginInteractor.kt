package com.example.meuprimeiroapp.interactor

import android.widget.Toast
import com.example.meuprimeiroapp.R
import com.example.meuprimeiroapp.domain.LoginData
import com.example.meuprimeiroapp.domain.LoginResult
import com.example.meuprimeiroapp.repository.LoginRepository

class LoginInteractor {

    val repo = LoginRepository()

  suspend  fun login(data: LoginData): LoginResult {

        val resultado = LoginResult()

        if(data.email.isNullOrBlank()){
            resultado.error = "ERRO_EMAIL_VAZIO"
            return resultado
        }
        if(data.pass.isNullOrBlank()){
            resultado.error = "ERRO_SENHA_VAZIA"
            return resultado
        }
        if(data.pass.length < 6){
            resultado.error = "ERRO_SENHA_MENOR_QUE_6"
            return resultado
        }
        val resultadoRepo = repo.login(data)

          return resultadoRepo

    }

    fun esqueciSenha(){

    }

    fun register(){

    }
}