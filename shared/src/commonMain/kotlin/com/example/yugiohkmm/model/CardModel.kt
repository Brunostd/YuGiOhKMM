package com.example.yugiohkmm.model

import kotlinx.serialization.Serializable

@Serializable
data class CardModel(
    val data: List<InfoModel>
) {
}