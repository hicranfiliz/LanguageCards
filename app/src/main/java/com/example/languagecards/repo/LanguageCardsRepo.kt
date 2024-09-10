package com.example.languagecards.repo

import com.example.languagecards.R
import com.example.languagecards.model.LanguageCard

object LanguageCardsRepo {

    fun getLanguageCards(): List<LanguageCard> {
        return listOf(
            LanguageCard("Apple", "Elma", R.drawable.apple1, 1),
            LanguageCard("Banana", "Muz", R.drawable.banana, 1),
            LanguageCard("Cat", "Kedi", R.drawable.cat, 1),
            LanguageCard("Dog", "Köpek", R.drawable.dog, 1),
            LanguageCard("Car", "Araba", R.drawable.car, 1),
            LanguageCard("House", "Ev", R.drawable.house, 1),
            LanguageCard("Sun", "Güneş", R.drawable.sun, 1),
            LanguageCard("Book", "Kitap", R.drawable.books, 1),
            LanguageCard("Tree", "Ağaç", R.drawable.tree, 1),
            LanguageCard("Water", "Su", R.drawable.water, 1),

            LanguageCard("Elephant", "Fil", R.drawable.elephant, 2),
//            LanguageCard("Mountain", "Dağ", R.drawable.mountain, 2),
//            LanguageCard("River", "Nehir", R.drawable.river, 2),
//            LanguageCard("Computer", "Bilgisayar", R.drawable.computer, 2),
//            LanguageCard("Flower", "Çiçek", R.drawable.flower, 2),
//            LanguageCard("Forest", "Orman", R.drawable.forest, 2),
//            LanguageCard("Phone", "Telefon", R.drawable.phone, 2),
//            LanguageCard("School", "Okul", R.drawable.school, 2),
//            LanguageCard("Doctor", "Doktor", R.drawable.doctor, 2),
//            LanguageCard("Teacher", "Öğretmen", R.drawable.teacher, 2),
//
//            // Level 3 (Orta-Zor kelimeler)
//            LanguageCard("University", "Üniversite", R.drawable.university, 3),
//            LanguageCard("Development", "Gelişim", R.drawable.development, 3),
//            LanguageCard("Experience", "Deneyim", R.drawable.experience, 3),
//            LanguageCard("Knowledge", "Bilgi", R.drawable.knowledge, 3),
//            LanguageCard("Airplane", "Uçak", R.drawable.airplane, 3),
//            LanguageCard("Journey", "Yolculuk", R.drawable.journey, 3),
//            LanguageCard("Hospital", "Hastane", R.drawable.hospital, 3),
//            LanguageCard("Library", "Kütüphane", R.drawable.library, 3),
//            LanguageCard("Vacation", "Tatil", R.drawable.vacation, 3),
//            LanguageCard("Language", "Dil", R.drawable.language, 3),
//
//            // Level 4 (Zor kelimeler)
//            LanguageCard("Astronomy", "Astronomi", R.drawable.astronomy, 4),
//            LanguageCard("Philosophy", "Felsefe", R.drawable.philosophy, 4),
//            LanguageCard("Architecture", "Mimarlık", R.drawable.architecture, 4),
//            LanguageCard("Psychology", "Psikoloji", R.drawable.psychology, 4),
//            LanguageCard("Biology", "Biyoloji", R.drawable.biology, 4),
//            LanguageCard("Engineering", "Mühendislik", R.drawable.engineering, 4),
//            LanguageCard("Literature", "Edebiyat", R.drawable.literature, 4),
//            LanguageCard("Geography", "Coğrafya", R.drawable.geography, 4),
//            LanguageCard("Environment", "Çevre", R.drawable.environment, 4),
//            LanguageCard("Technology", "Teknoloji", R.drawable.technology, 4),
//
//            // Level 5 (Çok zor kelimeler)
//            LanguageCard("Anthropology", "Antropoloji", R.drawable.anthropology, 5),
//            LanguageCard("Quantum", "Kuantum", R.drawable.quantum, 5),
//            LanguageCard("Philosophical", "Felsefi", R.drawable.philosophical, 5),
//            LanguageCard("Evolution", "Evrim", R.drawable.evolution, 5),
//            LanguageCard("Metaphysics", "Metafizik", R.drawable.metaphysics, 5),
//            LanguageCard("Sociology", "Sosyoloji", R.drawable.sociology, 5),
//            LanguageCard("Genetics", "Genetik", R.drawable.genetics, 5),
//            LanguageCard("Thermodynamics", "Termodinamik", R.drawable.thermodynamics, 5),
//            LanguageCard("Neuroscience", "Sinirbilim", R.drawable.neuroscience, 5),
//            LanguageCard("Philosophical Logic", "Felsefi Mantık", R.drawable.philosophical_logic, 5)
        )
    }
}