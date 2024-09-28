package com.unlam.marvel.di


import com.unlam.marvel.ui.screen.listscreen.ListScreenViewmodel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel {
        ListScreenViewmodel(get(),get())
    }
}
