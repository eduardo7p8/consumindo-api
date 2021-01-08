package com.example.meuprimeiroapp.view.activity

import com.example.meuprimeiroapp.viewmodel.LoginViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.observe
import com.example.meuprimeiroapp.R
import com.example.meuprimeiroapp.domain.LoginData
import com.example.meuprimeiroapp.domain.LoginResult

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

   lateinit var viewmodel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btLogin.setOnClickListener {  login()   }
        tvForgot.setOnClickListener { forgotPassword() }
        tvRegister.setOnClickListener{ register()}
        viewmodel = LoginViewModel(application)
        viewmodel.resultadoParaTela.observe(this){resultado ->
    processarResultadoLogin(resultado)
        }


    }

    fun processarResultadoLogin(res: LoginResult){
         if(res.error != null){
              Toast.makeText(this, res.error, Toast.LENGTH_LONG).show()
             return
        }
         val intentHome = Intent(this, HomeActivity::class.java)
         startActivity(intentHome)
         finish()
    }


    fun login(){
    val email = etEmail.text.toString()
        val pass = etPassword.text.toString()

        val data = LoginData(email, pass)

        viewmodel.login(data)


    }
    fun forgotPassword(){

    }

    fun register(){
        val intentRegister = Intent(this, RegisterActivity::class.java)
        startActivity(intentRegister)
    }
}