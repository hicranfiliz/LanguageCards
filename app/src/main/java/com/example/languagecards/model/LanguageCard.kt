package com.example.languagecards.model

data class LanguageCard(
    val word: String,
    val meaning : String,
    val image: Int,
    val level : Int,
    val sentence : String,
    val soundResId: Int? = null,) {

}