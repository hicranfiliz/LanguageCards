package com.example.languagecards

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.languagecards.databinding.FragmentQuizBinding
import com.example.languagecards.model.LanguageCard
import com.example.languagecards.repo.LanguageCardsRepo
class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding
    private lateinit var learnedWords: List<LanguageCard>
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizBinding.inflate(inflater, container, false)

        binding.toolbar.findViewById<ImageView>(R.id.ivBack).setOnClickListener {
            findNavController().navigateUp()
        }

        val sharedPref = requireContext().getSharedPreferences("LearnedWords", Context.MODE_PRIVATE)
        val learnedWordNames = sharedPref.all.keys.toList()

        val allWords = LanguageCardsRepo.getLanguageCards()
        learnedWords = allWords.filter { learnedWordNames.contains(it.word) }

        showQuestion()

        binding.ivOption1.setOnClickListener { checkAnswer(0) }
        binding.ivOption2.setOnClickListener { checkAnswer(1) }
        binding.ivOption3.setOnClickListener { checkAnswer(2) }
        binding.ivOption4.setOnClickListener { checkAnswer(3) }

        binding.btnNext.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < learnedWords.size) {
                showQuestion()
            } else {
                showScoreAndAnimation()
//                binding.tvQuestion.text = "Quiz Finished! Your score: $score/${learnedWords.size}"
//                binding.ivOption1.visibility = View.GONE
//                binding.ivOption2.visibility = View.GONE
//                binding.ivOption3.visibility = View.GONE
//                binding.ivOption4.visibility = View.GONE
//                binding.btnNext.visibility = View.GONE
//                binding.btnFinish.visibility = View.VISIBLE
            }
        }

        binding.btnFinish.setOnClickListener {
            findNavController().navigateUp()
        }


        return binding.root
    }

    private fun showQuestion() {
        val currentWord = learnedWords[currentQuestionIndex]
        binding.tvQuestion.text = "Which one is the '${currentWord.word}'?"

        val options = learnedWords.shuffled().take(4).toMutableList()
        if (!options.contains(currentWord)) {
            options[0] = currentWord
        }
        options.shuffle()

        binding.ivOption1.setImageResource(options[0].image)
        binding.ivOption2.setImageResource(options[1].image)
        binding.ivOption3.setImageResource(options[2].image)
        binding.ivOption4.setImageResource(options[3].image)

        binding.ivOption1.tag = options[0] == currentWord
        binding.ivOption2.tag = options[1] == currentWord
        binding.ivOption3.tag = options[2] == currentWord
        binding.ivOption4.tag = options[3] == currentWord
    }

    private fun checkAnswer(selectedOptionIndex: Int) {
        val selectedOption = when (selectedOptionIndex) {
            0 -> binding.ivOption1.tag
            1 -> binding.ivOption2.tag
            2 -> binding.ivOption3.tag
            3 -> binding.ivOption4.tag
            else -> false
        }

        if (selectedOption == true) {
            score++
            binding.tvQuestion.text = "Correct!"
            binding.tvQuestion.setTextColor(resources.getColor(R.color.correct))
        } else {
            binding.tvQuestion.text = "Incorrect!"
            binding.tvQuestion.setTextColor(resources.getColor(R.color.incorrect))
        }

        Handler(Looper.getMainLooper()).postDelayed({
            binding.tvQuestion.setTextColor(resources.getColor(R.color.black)) // Renk tekrar siyah
        }, 1000)
    }

    private fun showScoreAndAnimation() {
        binding.tvQuestion.text = "Your score: $score/${learnedWords.size}"

//        val anim = binding.lottieAnimationView
//
//        Handler(Looper.getMainLooper()).postDelayed({
//            anim.visibility = View.VISIBLE
//            anim.playAnimation()
//        }, 6000)

        binding.lottieAnimationView.visibility = View.VISIBLE
        binding.lottieAnimationView.setAnimation(R.raw.score)
        binding.lottieAnimationView.playAnimation()

        binding.ivOption1.visibility = View.GONE
        binding.ivOption2.visibility = View.GONE
        binding.ivOption3.visibility = View.GONE
        binding.ivOption4.visibility = View.GONE
        binding.btnNext.visibility = View.GONE
        binding.btnFinish.visibility = View.GONE
    }
}
