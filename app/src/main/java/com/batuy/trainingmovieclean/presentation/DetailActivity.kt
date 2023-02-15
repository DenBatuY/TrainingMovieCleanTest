package com.batuy.trainingmovieclean.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts.SettingsColumns.KEY
import com.batuy.trainingmovieclean.R
import com.batuy.trainingmovieclean.databinding.ActivityDetailBinding
import com.batuy.trainingmovieclean.databinding.FragmentFavouriteFilmsBinding
import com.batuy.trainingmovieclean.domain.Movie

class DetailActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val getKey = intent.getStringExtra(KEY) ?: ""
        if (getKey == KEY_DETAIL) {
            val getIntentMovie = intent.getParcelableExtra<Movie>(MOVIE) as Movie
            initialFragmentInfo(getIntentMovie)
        }else{
            initialFragmentFavouriteMovies()
        }


    }


    private fun initialFragmentInfo(movie: Movie) {
        supportFragmentManager.beginTransaction().replace(
            R.id.fragmentContainerView,
            DetailInfoFragment.newInstance(movie)
        ).commit()
    }

    private fun initialFragmentFavouriteMovies(){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,FavouriteFilmsFragment.newInstance()).commit()
    }

    companion object {
        private const val MOVIE = "movie"
        private const val KEY = "key"
        private const val KEY_DETAIL = "detail"
        private const val KEY_FAVOURITE = "favourite"

        fun newIntent(context: Context, movie: Movie): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MOVIE, movie)
            intent.putExtra(KEY, KEY_DETAIL)
            return intent
        }
        fun newIntentFavouriteMovie(context: Context):Intent{
          return  Intent(context,DetailActivity::class.java)
        }
    }

}