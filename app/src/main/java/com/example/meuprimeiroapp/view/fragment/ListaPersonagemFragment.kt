package com.example.meuprimeiroapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meuprimeiroapp.R
import com.example.meuprimeiroapp.databinding.FragmentListaPersonagemBinding
import com.example.meuprimeiroapp.domain.Personagen
import com.example.meuprimeiroapp.view.adapter.AdaptadorPersonagens
import com.example.meuprimeiroapp.viewmodel.ApiViewModel


class ListaPersonagemFragment : Fragment() {

    private lateinit var binding: FragmentListaPersonagemBinding
    private val viewModel: ApiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListaPersonagemBinding.inflate(inflater, container, false)
        binding.meuFragmento = this
        binding.lifecycleOwner = this

        viewModel.resultadoParaTela.observe(viewLifecycleOwner) { lista ->
            mostraResultadoApi(lista)

        }

        binding.rvPersonagens.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    fun mostraResultadoApi(lista: List<Personagen>) {
        //  var p = lista.first()
        //  var str = "nome: ${p.nome}"
        //  Toast.makeText(context, str, Toast.LENGTH_LONG).show()
        val adaptador = AdaptadorPersonagens(lista)

        binding.rvPersonagens.adapter = adaptador

    }


    fun chamarAPI() {
        viewModel.chamarAPI()
    }

}