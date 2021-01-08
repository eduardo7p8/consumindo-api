package com.example.meuprimeiroapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.meuprimeiroapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btRegister.setOnClickListener { register() }
        btVoltarRegistro.setOnClickListener { back() }
    }

    fun register(){
        val email = etEmailRegister.text.toString()
        val pass = etPasswordRegister.text.toString()
        val passRepite = etPasswordRepiterRegister.text.toString()

        if(email.isNullOrBlank()){
            val str = getString(R.string.email_required)
            Toast.makeText(this, str, Toast.LENGTH_LONG).show()
            return
        }
        if(pass.isNullOrBlank()){
            Toast.makeText(this, "O senha é obrigatorio", Toast.LENGTH_LONG).show()
            return
        }
        if(passRepite.isNullOrBlank()){
            Toast.makeText(this, "O senha é obrigatorio", Toast.LENGTH_LONG).show()
            return
        }
        if(pass.length < 6){
            Toast.makeText(this, "A senha deve possuir 6 caracteres", Toast.LENGTH_LONG).show()
            return
        }
        if(passRepite.length < 6){
            Toast.makeText(this, "A senha deve possuir 6 caracteres", Toast.LENGTH_LONG).show()
            return
        }
        if(pass != passRepite){
            Toast.makeText(this, "As senha estão diferentes", Toast.LENGTH_LONG).show()
            return
        }


        val auth = FirebaseAuth.getInstance()
        val operacao = auth.createUserWithEmailAndPassword(email,pass)
        operacao.addOnCompleteListener { result ->
            if(result.isSuccessful){
                Toast.makeText(this, "Usuario criado com Sucesso", Toast.LENGTH_LONG).show()

                finish()
            }else{
                Toast.makeText(this, "Erro na criação: ${result.exception?.localizedMessage}", Toast.LENGTH_LONG).show()

            }
        }
    }
    fun back(){
        finish()
    }
}