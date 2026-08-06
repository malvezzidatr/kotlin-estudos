package com.estudo.pokedexapp.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import coil.load
import com.estudo.pokedexapp.databinding.PokemonDetailBinding
import com.estudo.pokedexapp.domain.model.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private val viewModel: PokemonDetailViewModel by viewModels()
    private lateinit var binding: PokemonDetailBinding

    companion object {
        private const val EXTRA_POKEMON_ID = "extra_pokemon_id"

        fun newIntent(context: Context, pokemonId: Int): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_POKEMON_ID, pokemonId)
            }
        }


    }

    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)

        binding = PokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonId = intent.getIntExtra(EXTRA_POKEMON_ID, -1)

        viewModel.loadPokemonDetail(pokemonId.toString())

        observeUiState()
    }

    fun observeUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    when (state) {
                        is UiState.Loading -> {
                            binding.progressBar.visibility = android.view.View.VISIBLE
                            binding.pokemonName.visibility = android.view.View.GONE
                            binding.pokemonImage.visibility = android.view.View.GONE
                            binding.pokemonHeight.visibility = android.view.View.GONE
                            binding.pokemonWeight.visibility = android.view.View.GONE
                        }

                        is UiState.Success -> {
                            binding.progressBar.visibility = android.view.View.GONE
                            binding.pokemonName.visibility = android.view.View.VISIBLE
                            binding.pokemonImage.visibility = android.view.View.VISIBLE
                            binding.pokemonHeight.visibility = android.view.View.VISIBLE
                            binding.pokemonWeight.visibility = android.view.View.VISIBLE

                            val pokemon = state.data
                            binding.pokemonImage.load(pokemon.imageUrl)
                            binding.pokemonName.text = pokemon.name
                            binding.pokemonHeight.text = "Height: ${pokemon.height}"
                            binding.pokemonWeight.text = "Weight: ${pokemon.weight}"
                        }

                        is UiState.Error -> {
                            binding.progressBar.visibility = android.view.View.GONE
                            binding.pokemonName.visibility = android.view.View.GONE
                            binding.pokemonImage.visibility = android.view.View.GONE
                            binding.pokemonHeight.visibility = android.view.View.GONE
                            binding.pokemonWeight.visibility = android.view.View.GONE
                        }
                    }
                }
            }
        }
    }
}