package com.ifs21021.dinopedia

data class Dino(
    val name: String,
    val description: String,
    val characteristics: String,
    val group: String,
    val habitat: String,
    val food: String,
    val length: String,
    val height: String,
    val weight: String,
    val weakness: String,
    val imageResource: Int // Resource ID for image
)