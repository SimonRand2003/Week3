package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.bignerdranch.android.geoquiz.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding



    private val questionBank = listOf(
        Question (R.string.question_australia, true),
        Question (R.string.question_ocean, true),
        Question (R.string.question_mideast, false),
        Question (R.string.question_africa, false),
        Question (R.string.question_americas, true),
        Question (R.string. question_asia, true))
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backButton.visibility = View.GONE



        binding.trueButton.setOnClickListener { view: View -> Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_SHORT).show()}

        binding.falseButton.setOnClickListener { view: View -> Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show() }

        binding.nextButton.setOnClickListener{
            currentIndex = (currentIndex+1)% questionBank.size
            updateQuestion()
            binding.backButton.visibility = View.VISIBLE

        }

        binding.backButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex = (currentIndex - 1) % questionBank.size
                updateQuestion()
                binding.backButton.visibility = View.VISIBLE
                if (currentIndex == 0){
                    binding.backButton.visibility = View.GONE
                }
            }

            else{
                binding.backButton.visibility = View.GONE
            }
        }


    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextview.setText(questionTextResId)    }


}