package com.batuy.trainingmovieclean.data.network.model


import com.google.gson.annotations.SerializedName

data class Votes(
    @SerializedName("await")
    val await: Int,
    @SerializedName("filmCritics")
    val filmCritics: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("imdb")
    val imdb: Int,
    @SerializedName("kp")
    val kp: Int,
    @SerializedName("russianFilmCritics")
    val russianFilmCritics: Int
)