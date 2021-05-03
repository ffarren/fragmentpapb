package com.example.fragmentpapb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentpapb.databinding.ActivityMainBinding
import com.example.fragmentpapb.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val accept = arguments?.getString("et")
        binding.etFirstFragment.setText(accept)


        binding.btnFirstFragment.setOnClickListener {
            val secondFragment = SecondFragment()
            val firstFragmentData = Bundle()
            firstFragmentData.putString("etFirstFragment", binding.etFirstFragment.text.toString())
            secondFragment.arguments = firstFragmentData

            fragmentManager?.beginTransaction()?.apply{
                replace(R.id.fragment, secondFragment, SecondFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }


    }




}