package com.mu.fishermannotes.model

data class Fishing(
    val id: Int? = null,
    val date: String,
    val location: String,
    val locationImage: Int,
    val conditionImage: Int,
    val temperature: Int,
    val windImage: Int,
    val windMin: Int,
    val windMax: Int,
    val moonImage: Int,
    val note: String
)
