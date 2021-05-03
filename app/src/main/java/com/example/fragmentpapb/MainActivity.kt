package com.example.fragmentpapb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.fragmentpapb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener{
            val firstFragment = FirstFragment()
            val data = Bundle()
            data.putString("et", binding.et.text.toString() )
            firstFragment.arguments = data
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragment,firstFragment)
                addToBackStack(null)
                commit()
            }
        }

    }
}