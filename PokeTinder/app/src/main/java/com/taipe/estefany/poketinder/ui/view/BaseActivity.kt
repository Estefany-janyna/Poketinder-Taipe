package com.taipe.estefany.poketinder.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.yuyakaido.android.cardstackview.Direction

abstract class BaseActivity<B: ViewBinding>(val bindingFactory: (LayoutInflater)->B) :
    AppCompatActivity(){

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }
    abstract fun OnCardDragging(direction: Direction?, ratio: Float)
    abstract fun OnCardRewound()
}