package com.example.languagecards.viewmodel

import androidx.lifecycle.ViewModel
import com.example.languagecards.model.LanguageCard

class LanguageCardsViewModel : ViewModel(){
    var cardList : List<LanguageCard> = emptyList()
}