package com.batuy.trainingmovieclean.presentation

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.batuy.trainingmovieclean.R
import com.batuy.trainingmovieclean.databinding.FragmentDetailInfoBinding
import com.batuy.trainingmovieclean.domain.Movie
import com.squareup.picasso.Picasso

class DetailInfoFragment : Fragment() {
    private var _binding: FragmentDetailInfoBinding? = null
    private val binding:FragmentDetailInfoBinding
    get() = _binding?:throw RuntimeException("FragmentDetailInfoBinding is null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailInfoBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get().load(getMoviesInfo().posterUrl).into(binding.poster)
        binding.moviesName.text = getMoviesInfo().name
        binding.movieYear.text = getMoviesInfo().year.toString()
        binding.movieDescription.text = getMoviesInfo().description
    }


    private fun getMoviesInfo():Movie{
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable<Movie>(MOVIE_DETAIL,Movie::class.java) as Movie
        } else {
            @Suppress("deprecation")
            requireArguments().getParcelable(MOVIE_DETAIL) !!
        }

    }

    companion object {
        private const val MOVIE_DETAIL = "detail"

        fun newInstance(movie: Movie) =
            DetailInfoFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MOVIE_DETAIL,movie)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}