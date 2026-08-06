package com.estudo.pokedexapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.estudo.pokedexapp.databinding.ActivityMainBinding
import com.estudo.pokedexapp.domain.model.UiState
import com.estudo.pokedexapp.ui.details.DetailActivity
import com.estudo.pokedexapp.ui.list.PokemonAdapter
import com.estudo.pokedexapp.ui.list.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PokemonAdapter
    private val viewModel: PokemonListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRecyclerView()
        observeUiState()
    }

    private fun setupRecyclerView() {
        adapter = PokemonAdapter { pokemon ->
            val intent = DetailActivity.newIntent(this, pokemon.id)
            startActivity(intent)
        }
        binding.recyclerViewPokemon.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewPokemon.adapter = adapter
    }

    private fun observeUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    when (state) {
                        is UiState.Loading -> {
                            binding.progressBar.visibility = android.view.View.VISIBLE
                            binding.recyclerViewPokemon.visibility = android.view.View.GONE
                            binding.textError.visibility = android.view.View.GONE
                        }
                        is UiState.Success -> {
                            binding.progressBar.visibility = android.view.View.GONE
                            binding.recyclerViewPokemon.visibility = android.view.View.VISIBLE
                            binding.textError.visibility = android.view.View.GONE
                            adapter.submitList(state.data)
                        }
                        is UiState.Error -> {
                            binding.progressBar.visibility = android.view.View.GONE
                            binding.recyclerViewPokemon.visibility = android.view.View.VISIBLE
                            binding.textError.visibility = android.view.View.GONE
                        }
                    }
                }
            }
        }
    }
}