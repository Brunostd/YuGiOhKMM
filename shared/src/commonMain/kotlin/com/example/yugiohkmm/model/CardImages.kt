package com.example.yugiohkmm.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class CardImages(
    val id: Int,
    val image_url: String,
    val image_url_small: String
) {
}