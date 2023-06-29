package com.taipe.estefany.poketinder.util

import android.content.Context
import android.content.SharedPreferences

import com.google.gson.Gson
import com.taipe.estefany.poketinder.data.model.User


class SharedPreferenceUtil {
    //companion object es el objoeto compañero que permite
    //el ingreso directo a SharePreferences, por mas que sea privado y es =static
    //se define valores pero constantes//
    //tiene acceso directo a los miembros de clase que se declara

    companion object{
        private  const val SHARED_PREFERENCE_KEY = "SHARED_PREFERENCE_KEY"
        private lateinit var sharedPreference: SharedPreferences
        private const val USER ="USER_KEY"
    }
    // función se utiliza para inicializar la instancia de SharedPreferences
    fun setSharedPreference(context: Context){
        sharedPreference = context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)
    }
//guardar un usuario
    fun saveUser(user: User){
        val gson = Gson()
        val jsonUser = gson.toJson(user)
        sharedPreference
            .edit()
            .putString(USER, jsonUser) //para agregar a shareprefence no permite agregar un objeto por lo tanto es conveniente convertir en formato json , desde la clase USER con su atributos. de dataclass a jSON convertir, y se guarda el objeto con string jSON
            .apply()
    }
//obtener el usuario
 //set,
    fun getUser(): User? {
        val gson = Gson()

        var user: User? = null

        val jsonUser = sharedPreference.getString(USER, "")

        user = gson.fromJson(jsonUser, User::class.java)

        return user
    }
    //json nos sirve como medio de comunicacion entre sistemas, formato JSON, APIS
}