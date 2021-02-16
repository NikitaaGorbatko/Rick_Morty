package nikitagorbatko.example.rickmorty.common

import nikitagorbatko.example.rickmorty.retrofit.RetrofitClient
import nikitagorbatko.example.rickmorty.retrofit.RetrofitServices

object Common {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}