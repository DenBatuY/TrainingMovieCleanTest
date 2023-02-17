package com.batuy.trainingmovieclean.presentation

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.batuy.trainingmovieclean.R
import com.batuy.trainingmovieclean.data.repository.MovieRepositoryImpl
import com.batuy.trainingmovieclean.databinding.ActivityMainBinding
import com.batuy.trainingmovieclean.presentation.adapter.Adapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val movieAdapter by lazy {
        Adapter()
    }
    @Inject
     lateinit var viewModelFactory: ViewModelFactory

   private val component by lazy {
       (application as MovieApp).component
   }

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        viewModel = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = movieAdapter

        viewModel.loadMovies()
        movieAdapter.onReachAndListener = { viewModel.loadMovies() }

        movieAdapter.onLongClickListener = {
            viewModel.insertFavouriteMovie(it)
            Log.d("test", "MainActivity ${it.name}")
        }

        movieAdapter.onClickListener = {
            if (binding.fragmentContainerView != null) {
                supportFragmentManager.popBackStack()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, DetailInfoFragment.newInstance(it))
                    .addToBackStack(null).commit()
            } else {
                startActivity(DetailActivity.newIntent(this@MainActivity, it))

            }

        }

        viewModel.isLoading.observe(this) {
            if (it == true) binding.progressBar?.visibility = View.VISIBLE
            else binding.progressBar?.visibility = View.GONE
        }


        viewModel.listOfMovie.observe(this) {
             //Log.d("test", "MainActivity $it")
            movieAdapter.submitList(it)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.favouriteMovies) {
            startActivity(DetailActivity.newIntentFavouriteMovie(this))
        }
        return super.onOptionsItemSelected(item)
    }
}