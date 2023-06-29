package com.taipe.estefany.poketinder.ui.view
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.taipe.estefany.poketinder.R
import com.taipe.estefany.poketinder.databinding.ActivityMainBinding
import com.taipe.estefany.poketinder.ui.viewModel.MainViewModel
import com.yuyakaido.android.cardstackview.Direction


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate){
    private val viewModel by lazy{ MainViewModel() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }

    override fun OnCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun OnCardRewound() {

    }


}


