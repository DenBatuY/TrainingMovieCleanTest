package com.batuy.trainingmovieclean.di

import android.app.Application
import com.batuy.trainingmovieclean.presentation.FavouriteFilmsFragment
import com.batuy.trainingmovieclean.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: FavouriteFilmsFragment)



    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}