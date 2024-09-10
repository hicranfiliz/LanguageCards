package com.example.languagecards.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.languagecards.databinding.ItemCardBinding
import com.example.languagecards.model.LanguageCard
import com.example.languagecards.viewholder.LCardViewHolder

class LanguageCardAdapter (
    private var cards : List<LanguageCard>,
    private val onItemClicked : (LanguageCard) -> Unit
) : RecyclerView.Adapter<LCardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LCardViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LCardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: LCardViewHolder, position: Int) {
        val card = cards[position]
        holder.binding.tvWordName.text = card.word
        holder.binding.tvMeaning.text = card.meaning
        holder.binding.tvLevel.text = "Level ${card.level}"
        holder.binding.imgCard.setImageResource(card.image)

        holder.binding.root.setOnClickListener{
            onItemClicked(card)
        }
    }

    fun updateData(newCardList: List<LanguageCard>) {
        cards = newCardList
        notifyDataSetChanged()
    }

}