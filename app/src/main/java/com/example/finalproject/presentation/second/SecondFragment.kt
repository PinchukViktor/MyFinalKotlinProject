package com.example.finalproject.presentation.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.finalproject.databinding.FragmentSecondfragmentBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondfragmentBinding? = null
    private val binding get() = _binding!!
    lateinit var secondViewModel: SecondViewModel

    companion object {
        val number = "number"
        val description = "description"
        val nameof = "nameof"
        val url = "url"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondfragmentBinding.inflate(inflater, container, false)
        secondViewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view).load(arguments?.getString(url)).fitCenter().into(binding.imageView2)
        binding.textViewDesk.text = arguments?.getString(description)
        binding.textViewName.text = arguments?.getString(nameof)

        secondViewModel.getFactsOfCat()
        secondViewModel.factsFromApi.observe(viewLifecycleOwner) {
            binding.textViewFact1.text = it
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}