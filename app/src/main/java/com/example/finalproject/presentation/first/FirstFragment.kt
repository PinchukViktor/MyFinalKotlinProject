package com.example.finalproject.presentation.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.R
import com.example.finalproject.data.local.CatDataBase
import com.example.finalproject.databinding.FragmentFirstfragmentBinding
import com.example.finalproject.presentation.second.SecondFragment


class FirstFragment : Fragment(), CustomAdapter.Listener {
    private var _binding: FragmentFirstfragmentBinding? = null
    private val binding get() = _binding!!

    lateinit var adapter: CustomAdapter
    lateinit var firstViewModel: FirstViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firstViewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        firstViewModel.vmData = CatDataBase.getDataFromDB()

        adapter = CustomAdapter(this)
        adapter.setArrayListOfMyAnimals(firstViewModel.vmData)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstfragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(itemView: Int) {

        val bundle = bundleOf(
            SecondFragment.number to itemView,
            SecondFragment.description to firstViewModel.vmData[itemView].details,
            SecondFragment.nameof to firstViewModel.vmData[itemView].titles,
            SecondFragment.url to firstViewModel.vmData[itemView].URL,
        )
        findNavController().navigate(R.id.action_firstfragment_to_secondfragment, bundle)

    }
}
