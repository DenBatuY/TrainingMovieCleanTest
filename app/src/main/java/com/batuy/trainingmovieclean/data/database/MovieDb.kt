package com.batuy.trainingmovieclean.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "loading_movies")
data class MovieDb (
        @PrimaryKey
        val id: Int?,
        val name: String?,
        val description: String?,
        val year: Int?,
        val posterUrl:String?,
        val ratingKp:Double?
      )