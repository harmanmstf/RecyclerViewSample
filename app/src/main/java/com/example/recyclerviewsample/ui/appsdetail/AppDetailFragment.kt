package com.example.recyclerviewsample.ui.appsdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.recyclerviewsample.databinding.FragmentAppDetailBinding


class AppDetailFragment : Fragment() {

    private var _binding: FragmentAppDetailBinding? = null
    private val binding get() = _binding!!
    private val args: AppDetailFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAppDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedApp = args.selectedApp

        with(binding) {
            ivIcon.setImageResource(selectedApp.icon)
            tvName.text = selectedApp.name
            tvReleaseDate.text = selectedApp.releaseDate
            tvDefinition.text = selectedApp.definition
            tvCategory.text = selectedApp.category
            tvUrl.text = selectedApp.storeUrl.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
