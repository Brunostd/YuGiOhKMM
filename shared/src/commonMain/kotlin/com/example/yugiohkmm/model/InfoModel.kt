package com.example.yugiohkmm.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonDecoder

@Serializable
data class InfoModel(
    val id: Int,
    val name: String,
    val type: String,
    val desc: String,
    val race: String,
    val card_images: List<CardImages>
) {
}