package com.batuy.trainingmovieclean.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Movie (
        val id: Int?,
        val name: String?,
        val description: String?,
        val year: Int?,
        val posterUrl:String?,
        val ratingKp:Double?
      ):Parcelable