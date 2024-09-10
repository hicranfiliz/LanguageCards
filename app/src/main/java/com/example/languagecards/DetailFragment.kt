package com.example.languagecards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.languagecards.model.LanguageCard


class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val cardName = arguments?.getString("cardName")
        val cardMeaning = arguments?.getString("cardMeaning")
        //val cardImage = arguments?.getInt("cardImage")

        view.findViewById<TextView>(R.id.tvCardName).text = cardName
        view.findViewById<TextView>(R.id.tvCardMeaning).text = cardMeaning

        return view

    }

}