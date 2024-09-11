package com.example.languagecards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.languagecards.databinding.FragmentDetailBinding
import com.example.languagecards.model.LanguageCard


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(inflater, container, false)

        binding.toolbar.setNavigationOnClickListener{
            findNavController().navigateUp()
        }

        val cardName = arguments?.getString("cardName")
        val cardMeaning = arguments?.getString("cardMeaning")
        val cardImage = arguments?.getInt("cardImage")
        val cardLevel = arguments?.getInt("cardLevel")
        val cardSentence = arguments?.getString("cardSentence")

        binding.tvCardName.text = cardName
        binding.tvCardMeaning.text = cardMeaning
        binding.ivCardImage.setImageResource(cardImage ?: R.drawable.iris)
        binding.tvCardLevel.text = "Level: $cardLevel"
        binding.tvCardSentence.text = cardSentence

        return binding.root

    }

}