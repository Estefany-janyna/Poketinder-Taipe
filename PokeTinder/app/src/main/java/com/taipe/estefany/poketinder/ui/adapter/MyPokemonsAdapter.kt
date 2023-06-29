package com.taipe.estefany.poketinder.ui.adapter;

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taipe.estefany.poketinder.R
import com.taipe.estefany.poketinder.data.database.entities.MyPokemonEntity;
import com.taipe.estefany.poketinder.ui.holder.MyPokemonsHolder


class MyPokemonsAdapter(val list: MutableList<MyPokemonEntity>):
    RecyclerView.Adapter<MyPokemonsHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPokemonsHolder {
        val view = parent.inflate(R.layout.item_pokemon_saved)
        return MyPokemonsHolder(view)
    }
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder:  MyPokemonsHolder, position: Int){
        val item = list[position]
        holder.bind(item)
    }

}
