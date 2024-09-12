package com.example.languagecards

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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

        binding.btnGetQuiz.setOnClickListener {
            findNavController().navigate(R.id.action_learnedFragment_to_quizFragment)
        }

        val sharedPref = requireContext().getSharedPreferences("LearnedWords", Context.MODE_PRIVATE)
        val learnedWordNames = sharedPref.all.keys.toList()

        val allWords = LanguageCardsRepo.getLanguageCards()
        val learnedWords = allWords.filter { learnedWordNames.contains(it.word) }

        if (learnedWords.isEmpty()) {
            binding.tvPlaceHolder.visibility = View.VISIBLE
            binding.ivPlaceholder.visibility = View.VISIBLE
            binding.rvLearnedCards.visibility = View.GONE
        } else {
            binding.tvPlaceHolder.visibility = View.GONE
            binding.ivPlaceholder.visibility = View.GONE
            binding.rvLearnedCards.visibility = View.VISIBLE

            val adapter = LearnedWordAdapter(learnedWords) { selectedCard ->
                val bundle = Bundle().apply {
                    putString("cardName", selectedCard.word)
                    putString("cardMeaning", selectedCard.meaning)
                    putInt("cardImage", selectedCard.image)
                    putInt("cardLevel", selectedCard.level)
                    putString("cardSentence", selectedCard.sentence)
                    putBoolean("isLearned", true)
                }
                findNavController().navigate(R.id.action_learnedFragment_to_detailFragment, bundle)
            }

            binding.rvLearnedCards.layoutManager = LinearLayoutManager(requireContext())
            binding.rvLearnedCards.adapter = adapter
        }


        return binding.root
    }
}