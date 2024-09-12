package com.example.languagecards.repo

import com.example.languagecards.R
import com.example.languagecards.model.LanguageCard

object LanguageCardsRepo {

    fun getLanguageCards(): List<LanguageCard> {
        return listOf(
            LanguageCard("Apple", "Elma", R.drawable.apple, 1, "I like to eat an apple every day for a healthy snack.", R.raw.apple),
            LanguageCard("Banana", "Muz", R.drawable.banana, 1, "Monkeys love to eat bananas in the jungle.", R.raw.banana),
            LanguageCard("Cat", "Kedi", R.drawable.cat, 1, "My cat loves to sit by the window and watch the birds.", R.raw.cat),
            LanguageCard("Dog", "Köpek", R.drawable.dog, 1, "The dog barked loudly when it saw a stranger.", R.raw.dog),
            LanguageCard("Car", "Araba", R.drawable.car, 1, "I drove my car to the beach on a sunny day.", R.raw.car),
            LanguageCard("House", "Ev", R.drawable.house, 1, "They built a new house near the river.", R.raw.house),
            LanguageCard("Sun", "Güneş", R.drawable.sun, 1, "The sun was shining brightly in the afternoon sky.", R.raw.sun),
            LanguageCard("Book", "Kitap", R.drawable.books, 1, "I’m reading an interesting book about history.", R.raw.book),
            LanguageCard("Tree", "Ağaç", R.drawable.tree, 1, "The old oak tree in the park provides a lot of shade.", R.raw.tree),
            LanguageCard("Water", "Su", R.drawable.water, 1, "It is important to drink enough water every day.", R.raw.water),

            LanguageCard("Elephant", "Fil", R.drawable.elephant, 2, "The elephant used its trunk to drink water from the pond.", R.raw.elephant),
            LanguageCard("Mountain", "Dağ", R.drawable.mountain, 2, "They climbed the mountain and enjoyed the beautiful view.", R.raw.mountain),
            LanguageCard("River", "Nehir", R.drawable.river, 2," We sat by the river and listened to the sound of the water.", R.raw.river),
            LanguageCard("Computer", "Bilgisayar", R.drawable.coding, 2, "I use my computer to work and play games.", R.raw.computer),
            LanguageCard("Flower", "Çiçek", R.drawable.iris, 2, "She gave me a beautiful flower from her garden.", R.raw.flower),
            LanguageCard("Forest", "Orman", R.drawable.forest, 2, "The forest was full of tall trees and singing birds.", R.raw.forest),
            LanguageCard("Phone", "Telefon", R.drawable.smartphone, 2, "I called my friend on the phone to tell her the news.", R.raw.phone),
            LanguageCard("School", "Okul", R.drawable.school, 2, "The children walked to school together in the morning.", R.raw.school),
            LanguageCard("Doctor", "Doktor", R.drawable.doctor, 2, "The doctor told me I need to rest for a few days.", R.raw.doctor),
            LanguageCard("Teacher", "Öğretmen", R.drawable.teacher, 2, "Our teacher gave us a fun assignment to do over the weekend.", R.raw.teacher),

            // Level 3 (Orta-Zor kelimeler)
            LanguageCard("Plane", "Uçak", R.drawable.plane, 3, "The plane flew across the ocean to reach its destination."),
            LanguageCard("Mirror", "Ayna", R.drawable.mirror, 3, "She looked at herself in the mirror before leaving the house."),
            LanguageCard("Yard", "Bahçe", R.drawable.fence, 3, "We played soccer in the yard during the summer."),
            LanguageCard("Shell", "Kabuk", R.drawable.shell, 3, "I found a beautiful shell on the beach during our vacation."),
            LanguageCard("Planet", "Gezegen", R.drawable.planet, 3, "The airplane took off smoothly and headed to New York."),
            LanguageCard("Coin", "Madeni Para", R.drawable.money, 3, "He flipped a coin to decide who would go first."),
            LanguageCard("Hospital", "Hastane", R.drawable.hospital, 3, "She had to stay in the hospital for a few days after the surgery."),
            LanguageCard("Library", "Kütüphane", R.drawable.library, 3, "I went to the library to study for my exams."),
            LanguageCard("Vacation", "Tatil", R.drawable.holiday, 3, "We are planning a family vacation to the mountains next month."),
            LanguageCard("Ligthouse", "Fener", R.drawable.lighthouse, 3, "The lighthouse guided the ships safely to the harbor at night."),

            // Level 4 (Zor kelimeler)
            LanguageCard("Astronomy", "Astronomi", R.drawable.astronomy, 4, "He has always been interested in astronomy and the stars."),
            LanguageCard("Bicycle", "Bisiklet", R.drawable.bicycle, 4, " I ride my bicycle to work every morning to stay healthy."),
            LanguageCard("Bridge", "Köprü", R.drawable.bridge, 4, "The old stone bridge crosses the river and leads into town."),
            LanguageCard("Castle", "Kale", R.drawable.castle, 4, "The castle on the hill was built hundreds of years ago."),
            LanguageCard("Fireplace", "Şömine", R.drawable.fireplace, 4, "We sat by the fireplace and enjoyed the warmth during the winter."),
            LanguageCard("Fountain", "Çeşme", R.drawable.fountain, 4, "The children played by the fountain in the middle of the square."),
            LanguageCard("Windmill", "Yel Değirmeni", R.drawable.windpower, 4, "The windmill turned slowly as the wind blew across the field."),
            LanguageCard("Violin", "Keman", R.drawable.violin, 4, "She plays the violin beautifully in the school orchestra."),
            LanguageCard("Kite", "Uçurtma", R.drawable.kite, 4, "The children flew their kite high in the sky at the park."),
            LanguageCard("Vessel", "Gemi", R.drawable.cruise, 4, "The large vessel sailed smoothly through the ocean waves."),

            // Level 5 (Çok zor kelimeler)
            LanguageCard("Clock Tower", "Saat Kulesi", R.drawable.clocktower, 5, "The clock tower rang twelve times to mark noon."),
            LanguageCard("Compass", "Pusula", R.drawable.compass, 5, "We used a compass to navigate through the dense forest."),
            LanguageCard("Desert", "Çöl", R.drawable.desert, 5, "The camel is well adapted to survive in the harsh desert environment."),
            LanguageCard("Dessert", "Tatlı", R.drawable.cake, 5, "We had a delicious chocolate cake for dessert after dinner."),
            LanguageCard("Binoculars", "Dürbün", R.drawable.binoculars, 5, "He used binoculars to get a closer look at the distant birds."),
            LanguageCard("Hurricane", "Kasırga", R.drawable.hurricane, 5, "The hurricane caused significant damage along the coastline."),
            LanguageCard("Luggage", "Bavul", R.drawable.luggage, 5, "We packed our luggage and headed to the airport for our flight."),
            LanguageCard("Ladder", "Merdiven", R.drawable.ladder, 5, "He climbed the ladder to reach the roof of the house."),
            LanguageCard("Chandelier", "Avize", R.drawable.chandelier, 5, "The chandelier in the ballroom sparkled with thousands of crystals."),
            LanguageCard("Bat", "Yarasa", R.drawable.bat, 5, "The bat flew silently through the night in search of food.")
        )
    }
}