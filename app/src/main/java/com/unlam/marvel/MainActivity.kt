package com.unlam.marvel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.unlam.marvel.data.HeroAdapter
import com.unlam.marvel.databinding.ActivityMainBinding
import com.unlam.marvel.domain.Hero
import com.unlam.marvel.ui.HeroViewModel
import com.unlam.marvel.ui.ScreenState
import com.unlam.marvel.ui.VerticalSpaceItemDecoration
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var heroAdapter: HeroAdapter
    //private val viewModel by viewModels<HeroViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup del listado
        heroAdapter = HeroAdapter()
        val verticalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        with(binding.charactersList) {
            this.adapter = heroAdapter
            this.layoutManager = verticalLayoutManager
            this.addItemDecoration(VerticalSpaceItemDecoration(16))
        }

        // Listen to Retrofit response
        /*
        val viewModel =
            ViewModelProvider(this, HeroViewModelFactory())[HeroViewModel::class.java]
        */
        val viewModel = getViewModel<HeroViewModel>()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.screenState.collect {
                    when (it) {
                        ScreenState.Loading -> showLoading()
                        is ScreenState.ShowCharacters -> showCharacters(it.list)
                        else -> {}
                    }
                }
            }
        }
    }

    private fun showLoading() {

    }

    private fun showCharacters(list: List<Hero>) {
        heroAdapter.submitList(list)
    }
}
