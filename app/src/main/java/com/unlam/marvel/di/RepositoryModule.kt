package com.unlam.marvel.di

import com.unlam.marvel.data.login.ILogInService
import com.unlam.marvel.data.login.LogInService
import com.unlam.marvel.data.repository.hero.HeroRepository
import com.unlam.marvel.data.repository.hero.IHeroRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ILogInService> {
        LogInService()
    }
    single<IHeroRepository> {
        HeroRepository(get())
    }
}
