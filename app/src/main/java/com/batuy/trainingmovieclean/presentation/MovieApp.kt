package com.batuy.trainingmovieclean.presentation

import android.app.Application
import com.batuy.trainingmovieclean.di.DaggerApplicationComponent

class MovieApp : Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}