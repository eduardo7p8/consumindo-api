package com.example.meuprimeiroapp.interactor

import com.example.meuprimeiroapp.domain.Personagen
import com.example.meuprimeiroapp.repository.ApiRepository


class ApiInteractor {

    val repo = ApiRepository()

  suspend   fun chamarAPI() : List<Personagen> {
            return repo.chamarAPI()
    }
}