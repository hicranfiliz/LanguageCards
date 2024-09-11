package com.example.languagecards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.languagecards.adapter.LanguageCardAdapter
import com.example.languagecards.databinding.FragmentWordCardsBinding
import com.example.languagecards.model.LanguageCard
import com.example.languagecards.repo.LanguageCardsRepo
import kotlin.concurrent.thread

class WordCardsFragment : Fragment() {

    private lateinit var binding: FragmentWordCardsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWordCardsBinding.inflate(inflater, container, false)

        var cardList = LanguageCardsRepo.getLanguageCards()

        val adapter = LanguageCardAdapter(cardList){ selectedCard ->
            val bundle = Bundle()
            bundle.putString("cardName", selectedCard.word)
            bundle.putString("cardMeaning", selectedCard.meaning)
            bundle.putInt("cardImage", selectedCard.image)
            bundle.putInt("cardLevel", selectedCard.level)
            bundle.putString("cardSentence", selectedCard.sentence)

            findNavController().navigate(R.id.action_wordCardsFragment_to_detailFragment, bundle)

        }
        binding.rvCards.adapter = adapter
        binding.rvCards.layoutManager = LinearLayoutManager(requireContext())

        binding.swipeRefreshLayout.setOnRefreshListener {
            cardList = LanguageCardsRepo.getLanguageCards().shuffled()
            adapter.updateData(cardList)
            binding.swipeRefreshLayout.isRefreshing = false
        }

        return binding.root
    }
}