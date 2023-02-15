package com.batuy.trainingmovieclean.data.network.model


import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("alternativeName")
    val alternativeName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("externalId")
    val externalId: ExternalId,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: Logo,
    @SerializedName("movieLength")
    val movieLength: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("names")
    val names: List<Name>,
    @SerializedName("poster")
    val poster: Poster,
    @SerializedName("rating")
    val rating: Rating,
    @SerializedName("shortDescription")
    val shortDescription: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("votes")
    val votes: Votes,
    @SerializedName("watchability")
    val watchability: Watchability,
    @SerializedName("year")
    val year: Int
)