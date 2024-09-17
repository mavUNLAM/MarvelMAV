package com.unlam.marvel.di


import com.unlam.marvel.ui.HeroViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel {
        HeroViewModel(get())
    }
}
