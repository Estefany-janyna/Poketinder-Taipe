package com.taipe.estefany.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import com.taipe.estefany.poketinder.databinding.ActivityLoginBinding
import com.taipe.estefany.poketinder.ui.viewModel.LoginViewModel

import com.yuyakaido.android.cardstackview.Direction


class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnLogin.setOnClickListener {
            startLogin()
        }

        binding.btnRegister.setOnClickListener {
            startActivity( Intent (this, RegisterActivity::class.java))
        }

        loginViewModel = LoginViewModel(this)

        loginViewModel.onCreate()

        loginViewModel.emptyFieldsError.observe(this) {
            Toast.makeText(this, "Ingrese datos de usauario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.fieldsAuthenticateError.observe(this) {
            Toast.makeText(this, "Error de usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.goSuccessActivity.observe(this) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun OnCardDragging(direction: Direction?, ratio: Float) {

    }
    override fun OnCardRewound() {

    }

    fun startLogin() {
        loginViewModel.validateInputs(
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString()
        )
    }
}