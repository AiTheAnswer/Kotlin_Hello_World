package com.allen.kotlin

import android.app.Application
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
        val client = OkHttpClient()
        val picasso = Picasso.Builder(this)
                .downloader(OkHttp3Downloader(client))
                .build()
        Picasso.setSingletonInstance(picasso)
    }
}

var application: Application? = null
