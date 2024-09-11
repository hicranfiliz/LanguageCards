package com.example.languagecards

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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

        binding.toolbar.findViewById<ImageView>(R.id.ivBack).setOnClickListener {
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
        binding.tvTitle.text = "$cardName DETAIL"


        val sharedPreferences = requireContext().getSharedPreferences("LearnedWords", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        binding.btnLearned.setOnClickListener {
            cardName?.let {
                editor.putString(it, it)
                editor.apply()
                Toast.makeText(requireContext(), "$it has been learned!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root

    }

}