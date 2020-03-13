package com.example.moviedolphin.ui.latest

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.moviedolphin.R

class LatestFragment : Fragment() {

    companion object {
        fun newInstance() = LatestFragment()
    }

    private lateinit var viewModel: LatestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.latest_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LatestViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
