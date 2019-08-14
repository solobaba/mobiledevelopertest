package com.example.mobiledevelopertest

import android.app.Application
import android.content.Context
import com.example.mobiledevelopertest.Database.RoomSingleton

class App : Application(){
    companion object {
        lateinit var context : Context

        fun getInstance(context: Context) : RoomSingleton {
            App.context = context
            return RoomSingleton.getInstance(App.context)
        }
    }
}