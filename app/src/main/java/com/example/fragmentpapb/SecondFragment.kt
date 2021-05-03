package com.example.fragmentpapb

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentpapb.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding : FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val accept = arguments?.getString("etFirstFragment")
        binding.tvSecondFragment.text = accept

        binding.btnSecondFragment.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$accept"))
            startActivity(intent)
        }
    }

}