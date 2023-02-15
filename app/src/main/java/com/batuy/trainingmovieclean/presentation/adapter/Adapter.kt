package com.batuy.trainingmovieclean.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.batuy.trainingmovieclean.databinding.MovieItemBinding
import com.batuy.trainingmovieclean.domain.Movie
import com.squareup.picasso.Picasso

class Adapter : ListAdapter<Movie, ViewHolder>(MovieDiffUtilCallback()) {

    var a = 1
    var onReachAndListener: (() -> Unit)? = null
    var onClickListener: ((movie: Movie) -> Unit)? = null
    var onLongClickListener: ((movie: Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Log.d("test","onCreateViewHolder $a")
        //a++
        val binding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Log.d("test","onBindViewHolder $a")
//        a++
        val movie = getItem(position)
        with(holder.binding) {
            Picasso.get().load(movie.posterUrl).into(imageViewPoster)
            textViewRating.text = movie.ratingKp.toString()

            root.setOnClickListener { onClickListener?.invoke(movie) }

            root.setOnLongClickListener {
                onLongClickListener?.invoke(movie)

               true
            }
        }

        if (position == itemCount - 10) {
            onReachAndListener?.invoke()
        }
    }
}