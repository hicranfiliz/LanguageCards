package com.example.languagecards

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.languagecards.adapter.LanguageCardAdapter
import com.example.languagecards.databinding.FragmentWordCardsBinding
import com.example.languagecards.model.LanguageCard
import com.example.languagecards.repo.LanguageCardsRepo
import com.example.languagecards.viewmodel.LanguageCardsViewModel
import kotlin.concurrent.thread

class WordCardsFragment : Fragment() {

    private lateinit var binding: FragmentWordCardsBinding
    private lateinit var viewModel: LanguageCardsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWordCardsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LanguageCardsViewModel::class.java)

        initializeCardList()
        setUpRecyclerView()
        swipetoRefresh()

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences = requireContext().getSharedPreferences("LearnedWords", Context.MODE_PRIVATE)
        val learnedCards = sharedPreferences.all.keys

        val updateCardList = viewModel.cardList.filter {
            !learnedCards.contains(it.word)
        }

        if (updateCardList.size != viewModel.cardList.size){
            viewModel.cardList = updateCardList
            (binding.rvCards.adapter as LanguageCardAdapter).updateData(viewModel.cardList)
        }
    }

    private fun initializeCardList(){
        if (viewModel.cardList.isEmpty()) {
            val sharedPreferences = requireContext().getSharedPreferences("LearnedWords", Context.MODE_PRIVATE)
            val learnedCards = sharedPreferences.all.keys

            var cardList = LanguageCardsRepo.getLanguageCards().shuffled()
            cardList = cardList.filter { !learnedCards.contains(it.word) }
            viewModel.cardList = cardList
        }
    }

    private fun setUpRecyclerView(){
        val adapter = LanguageCardAdapter(viewModel.cardList){ selectedCard ->
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
    }

    private fun swipetoRefresh(){
        binding.swipeRefreshLayout.setOnRefreshListener {
            val sharedPreferences = requireContext().getSharedPreferences("LearnedWords", Context.MODE_PRIVATE)
            val learnedCards = sharedPreferences.all.keys

            val cardList = LanguageCardsRepo.getLanguageCards().shuffled().filter {
                !learnedCards.contains(it.word)
            }
            viewModel.cardList = cardList

            (binding.rvCards.adapter as LanguageCardAdapter).updateData(viewModel.cardList)
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }
}