package com.taipe.estefany.poketinder.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.taipe.estefany.poketinder.data.FirebaseRemoteConfigRepository

class InfoViewModel: ViewModel() {
    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init {
        firebaseRemoteConfigRepository.init()
    }

    fun getUrlPokemon(): MutableLiveData<String>
    {
        return firebaseRemoteConfigRepository.getUrlPokemonLiveData
    }
}