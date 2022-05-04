package com.github.yeeun_yun97.clone.googlebook

import android.app.Application
import com.github.yeeun_yun97.clone.googlebook.data.room.FavRoom

class GoogleBookApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //create room database
        FavRoom.openDatabase(applicationContext)
    }

}