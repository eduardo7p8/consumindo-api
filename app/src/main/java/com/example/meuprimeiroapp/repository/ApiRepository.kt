package com.example.meuprimeiroapp.repository

import com.example.meuprimeiroapp.domain.Personagen
import com.example.meuprimeiroapp.repository.dto.Page
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface RickMortyPersonagensApi {
    @GET("character")
    @Headers("Content-Type: application/json")
    suspend fun recuperarPersonagens(@Query("page") pagina: Int): Page
}



interface RickMortyEpisodiosELocalizacoes {
    @GET("location")
    suspend fun recuperarLocalizacoes()
    @GET("episode")
    suspend fun recuperarEpisodios()

}

class ApiRepository {

    private  val conector: Retrofit
    //rickandmortyapi.com/api

    init {
         val gsonConfig = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()

      conector = Retrofit.Builder()
          .baseUrl("https://rickandmortyapi.com/api/")
          .addConverterFactory(GsonConverterFactory.create(gsonConfig))
          .build()

    }

     suspend fun chamarAPI(): List<Personagen> {
        val service = conector.create(RickMortyPersonagensApi::class.java)
         val listaPersonagens = service.recuperarPersonagens(1).results

         return listaPersonagens.map {dto ->
             Personagen(
                 nome =dto.name,
                genero  =dto.gender,
                 tipo = dto. type,
                 foto = dto.image
                 )
         }
    }
}