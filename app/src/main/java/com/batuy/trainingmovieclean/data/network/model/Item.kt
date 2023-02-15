package com.batuy.trainingmovieclean.data.network.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("_id")
    val id: String,
    @SerializedName("logo")
    val logo: Logo,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)