package com.example.languagecards

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.languagecards.adapter.LearnedWordAdapter
import com.example.languagecards.databinding.FragmentLearnedBinding
import com.example.languagecards.repo.LanguageCardsRepo

class LearnedFragment : Fragment() {

    private lateinit var binding: FragmentLearnedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLearnedBinding.inflate(inflater, container, false)

        // SharedPreferences'tan verileri çekelim
        val sharedPref = requireContext().getSharedPreferences("LearnedWords", Context.MODE_PRIVATE)
        val learnedWordNames = sharedPref.all.keys.toList()

        // Tüm LanguageCard'ları içeren repository'miz
        val allWords = LanguageCardsRepo.getLanguageCards()

        // SharedPreferences'ta kaydedilen kelime adlarına göre, bu kelimelerin detaylarını bulalım
        val learnedWords = allWords.filter { languageCard ->
            learnedWordNames.contains(languageCard.word)
        }

        // Eğer learnedWords boş değilse RecyclerView'da göster
        if (learnedWords.isNotEmpty()) {
            binding.rvLearnedCards.layoutManager = LinearLayoutManager(requireContext())
            binding.rvLearnedCards.adapter = LearnedWordAdapter(learnedWords)
        } else {

            binding.tvPlaceHolder.visibility = View.VISIBLE
        }

        return binding.root
    }
}