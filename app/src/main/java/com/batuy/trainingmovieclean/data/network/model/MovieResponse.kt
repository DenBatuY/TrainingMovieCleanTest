package com.batuy.trainingmovieclean.data.network.model


import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("docs")
    val movieDto: List<MovieDto>,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("total")
    val total: Int
)