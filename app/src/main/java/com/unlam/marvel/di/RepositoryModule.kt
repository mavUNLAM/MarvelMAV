package com.unlam.marvel.di

import com.unlam.marvel.data.repository.HeroRepository
import com.unlam.marvel.data.repository.HeroService
import com.unlam.marvel.data.repository.IHeroRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IHeroRepository> {
        HeroRepository(get())
    }
    single {
        HeroService(get())
    }
}
