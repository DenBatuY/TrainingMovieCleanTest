package com.batuy.trainingmovieclean.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.batuy.trainingmovieclean.data.database.Dao
import com.batuy.trainingmovieclean.data.database.DataBase
import com.batuy.trainingmovieclean.data.mapper.Mapper
import com.batuy.trainingmovieclean.data.network.ApiFactory
import com.batuy.trainingmovieclean.data.network.ApiService
import com.batuy.trainingmovieclean.domain.Movie
import com.batuy.trainingmovieclean.domain.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val application: Application,
    private val mapper: Mapper,
    private val apiService:ApiService,
    private val dao: Dao
) : MovieRepository {

    private var page = 1

    private val movie = MutableLiveData<List<Movie>>()
    private val isLoading = MutableLiveData<Boolean>()

    override suspend fun loadMovies() {

        try {

            isLoading.value = true
            val moviesDto = apiService.loadMovies(page)

            val movieList = moviesDto.movieDto.map {
                mapper.mapMovieDtoToEntity(it)
            }

            val loadMovies: ArrayList<Movie>? = movie.value as ArrayList<Movie>?
            if (loadMovies == null) {
                movie.value = movieList
            } else {
                loadMovies.addAll(movieList)
                movie.value = loadMovies
            }
            page++
            isLoading.value = false
        } catch (e: java.lang.Exception) {
            Log.d("test", "load problem $e")
        }
    }

    override fun listOfMovie(): LiveData<List<Movie>> {
        return movie
    }

    override suspend fun insertFavouriteMovie(movie: Movie) {
        // Log.d("test", "MovieRepositoryImpl  ${movie.name}")
        dao.insertMovie(mapper.mapEntityToDbModel(movie))
    }

    override suspend fun deleteFavouriteMovie(movieId: Int) {
        dao.deleteFavouriteMovie(movieId)
    }

    override fun listFavouriteMovies(): LiveData<List<Movie>> {

        return Transformations.map(dao.getAllLoadingMovies()) { movieDbList ->
            movieDbList.map {
                mapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun favouriteMovie(id: Int): LiveData<Movie> {
        return Transformations.map(dao.grtFavouriteMovie(id)) {
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun isLoading(): LiveData<Boolean> {
        return isLoading
    }
}

