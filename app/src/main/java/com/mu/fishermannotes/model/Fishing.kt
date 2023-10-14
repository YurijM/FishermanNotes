package com.mu.fishermannotes.model

data class Fishing(
    val id: Int? = null,
    val location: String,
    val temperature: Int,
    val condition: String,
    val wind: String,
    val moonImage: Int,
    val date: String,
    val note: String
)
