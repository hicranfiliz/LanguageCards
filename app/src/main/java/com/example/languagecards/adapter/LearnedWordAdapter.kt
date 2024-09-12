package com.example.languagecards.adapter

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.languagecards.databinding.ItemCardBinding
import com.example.languagecards.model.LanguageCard
import com.example.languagecards.viewholder.LearnedViewHolder

class LearnedWordAdapter(
    private val learnedWords : List<LanguageCard>,
    private val clickListener: (LanguageCard) -> Unit
) : RecyclerView.Adapter<LearnedViewHolder>() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LearnedViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return learnedWords.size
    }

    override fun onBindViewHolder(holder: LearnedViewHolder, position: Int) {
        val learnedWord = learnedWords[position]

        holder.binding.tvWordName.text = learnedWord.word
        holder.binding.tvMeaning.text = learnedWord.meaning
        holder.binding.tvLevel.text = "Level: ${learnedWord.level}"
        holder.binding.imgCard.setImageResource(learnedWord.image)

        holder.itemView.setOnClickListener {
            clickListener(learnedWord)
        }

        holder.binding.ivSoundIcon.setOnClickListener {
            playSound(holder.binding.ivSoundIcon.context, learnedWord.soundResId)
        }
    }

    private fun playSound(context: android.content.Context, soundResId: Int?) {
        mediaPlayer?.release()

        soundResId?.let {
            mediaPlayer = MediaPlayer.create(context, it)
            mediaPlayer?.start()
        }
    }

    fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

}