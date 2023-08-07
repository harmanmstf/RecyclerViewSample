package com.example.recyclerviewsample.ui.appslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewsample.data.AppsDataSource
import com.example.recyclerviewsample.databinding.FragmentAppsListBinding

class AppsListFragment : Fragment() {

    private var _binding: FragmentAppsListBinding? = null
    private val binding get() = _binding!!

    private val dataSource = AppsDataSource()
    private val adapter = AppsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAppsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        binding.recyclerView.adapter = adapter

        val apps = dataSource.loadApps()
        adapter.submitList(apps)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
