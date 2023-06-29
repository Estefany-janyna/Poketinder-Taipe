package com.taipe.estefany.poketinder.ui.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.taipe.estefany.poketinder.data.database.entities.MyPokemonEntity
import com.taipe.estefany.poketinder.databinding.FragmentFavoriteBinding
import com.taipe.estefany.poketinder.ui.adapter.MyPokemonsAdapter
import com.taipe.estefany.poketinder.ui.viewModel.FavoriteViewModel


class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>
    (FragmentFavoriteBinding::inflate) {

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    private val listMyPokemon = mutableListOf<MyPokemonEntity>()

    private val adapter by lazy {MyPokemonsAdapter(listMyPokemon)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoriteViewModel.getMyPokemons(requireContext())
        binding.rvPokemons.adapter = adapter
        /**favoriteViewModel.myPokemonList.observe(this){
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }
        **/
        favoriteViewModel.myPokemonList.observe(this){ pokemonList ->
            listMyPokemon.clear()
            listMyPokemon.addAll(pokemonList)
            adapter.notifyDataSetChanged()
        }


        binding.floatingActionDelete.setOnClickListener{
            favoriteViewModel.deleteAllPokemon(requireContext())
        }
    }

}