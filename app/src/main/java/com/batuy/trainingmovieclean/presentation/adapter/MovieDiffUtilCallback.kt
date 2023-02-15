package com.batuy.trainingmovieclean.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.batuy.trainingmovieclean.domain.Movie

class MovieDiffUtilCallback:DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem==newItem
    }
}