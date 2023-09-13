package com.bignerdranch.android.ex4


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.bignerdranch.android.ex4.R
import com.bignerdranch.android.ex4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isStop = true
    private var isGo = false
    private var isWait = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.trafficButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))


        binding.trafficButton.setOnClickListener {
            if (isStop) {
                binding.trafficButton.text = "GO"
                binding.trafficButton.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                binding.redLight.visibility = View.INVISIBLE
                binding.greenLight.visibility = View.VISIBLE
                isStop = false
                isGo = true
                isWait = false
            } else if (isGo) {
                binding.trafficButton.text = "WAIT"
                binding.trafficButton.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
                binding.greenLight.visibility = View.INVISIBLE
                binding.yellowLight.visibility = View.VISIBLE
                isStop = false
                isGo = false
                isWait = true
            } else {
                binding.trafficButton.text = "STOP"
                binding.trafficButton.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
                binding.yellowLight.visibility = View.INVISIBLE
                binding.redLight.visibility = View.VISIBLE
                isStop = true
                isGo = false
                isWait = false
            }
        }
    }
}
