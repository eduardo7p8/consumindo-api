package com.example.meuprimeiroapp.repository

import android.content.Intent
import android.widget.Toast
import com.example.meuprimeiroapp.domain.LoginData
import com.example.meuprimeiroapp.domain.LoginResult
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LoginRepository {

  suspend fun login(data: LoginData) : LoginResult = suspendCoroutine{ resultadoPromisse ->
        //login com o firebase

        val auth = FirebaseAuth.getInstance()
        val operacao = auth.signInWithEmailAndPassword(data.email, data.pass)
        operacao.addOnCompleteListener { result ->
            val resultadoLogin = LoginResult()
            if(result.isSuccessful){
                resultadoLogin.result = "LOGIN_FIREBASE_SUCESSO"
            }else{
                resultadoLogin.error = "LOGIN_FIREBASE_ERRO"
            }
            resultadoPromisse.resume(resultadoLogin)
        }
    }

    fun esqueciSenha(data: LoginData){

    }

    fun register(data: LoginData){

    }

}
