package com.taipe.estefany.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.taipe.estefany.poketinder.databinding.ActivitySplashBinding
import com.taipe.estefany.poketinder.ui.viewModel.SplashViewModel
import com.yuyakaido.android.cardstackview.Direction

class SplashActivity: BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashViewModel.getIsUnderMaintenance().observe(this, Observer { isUnderMaintenance ->
            if (isUnderMaintenance) {
                Toast.makeText(this, "Bajo Mantenimiento", Toast.LENGTH_SHORT).show()
            } else {
                showAnimation()
            }
        })
    }

    override fun OnCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun OnCardRewound() {

    }


    private fun showAnimation() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 3000)
    }
}
