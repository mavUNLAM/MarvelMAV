package com.unlam.marvel.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unlam.marvel.data.network.IMarvelHeroClient
import com.unlam.marvel.data.network.PublicKeyInterceptor
import com.unlam.marvel.data.repository.HeroRepository
import com.unlam.marvel.data.repository.HeroService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(PublicKeyInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiClient = retrofit.create(IMarvelHeroClient::class.java)

        val charactersApi = HeroRepository(apiClient)
        val heroService = HeroService(charactersApi)
        return HeroViewModel(heroService) as T
    }
}
