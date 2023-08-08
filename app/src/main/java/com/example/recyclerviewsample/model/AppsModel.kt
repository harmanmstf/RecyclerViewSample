package com.example.recyclerviewsample.model


import java.io.Serializable


data class Apps(
    val name: String,
    val icon: Int,
    val releaseDate: String,
    val category: String,
    val storeUrl: Int,
    val definition: String,
) : Serializable