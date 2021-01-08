package com.example.meuprimeiroapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meuprimeiroapp.R
import com.example.meuprimeiroapp.databinding.ItemDoPersonagemBinding
import com.example.meuprimeiroapp.domain.Personagen

class AdaptadorPersonagens(val lista: List<Personagen>) :
    RecyclerView.Adapter<AdaptadorPersonagens.GuardaDadosPersoangem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuardaDadosPersoangem {
        val instanciaDoXml = LayoutInflater.from(parent.context).inflate(R.layout.item_do_personagem, parent, false)
        val guardador = GuardaDadosPersoangem(instanciaDoXml)
        return guardador
    }

    override fun onBindViewHolder(holder: GuardaDadosPersoangem, position: Int) {
        val binding = holder.binding
        val p = lista[position]
        binding.personagem = p
        binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return lista.size

    }


    inner class GuardaDadosPersoangem(v: View) : RecyclerView.ViewHolder(v) {
        val binding: ItemDoPersonagemBinding = ItemDoPersonagemBinding.bind(v)

    }
}