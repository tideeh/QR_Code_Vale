package br.com.polenflorestal.qrcodevale

import android.app.Application
import android.content.Context

class MyApp : Application() {

    companion object {
        lateinit var context: Context
        fun getAppContext():Context { return MyApp.context }
    }

    override fun onCreate() {
        super.onCreate()

        MyApp.context = applicationContext
    }

}