package com.batuy.trainingmovieclean.di

import android.app.Application
import com.batuy.trainingmovieclean.data.database.Dao
import com.batuy.trainingmovieclean.data.database.DataBase
import com.batuy.trainingmovieclean.data.network.ApiFactory
import com.batuy.trainingmovieclean.data.network.ApiService
import com.batuy.trainingmovieclean.data.repository.MovieRepositoryImpl
import com.batuy.trainingmovieclean.domain.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {

    @Binds
    fun bindMovieRepository(impl: MovieRepositoryImpl):MovieRepository

companion object{

    @Provides
    fun providesDao(application: Application):Dao{
        return DataBase.getInstance(application).dao()
    }

    @Provides
    fun providesApiService():ApiService{
        return ApiFactory.apiService
    }
}
}