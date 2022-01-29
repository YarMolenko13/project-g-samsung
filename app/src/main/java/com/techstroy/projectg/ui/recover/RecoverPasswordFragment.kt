package com.techstroy.projectg.ui.recover

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.techstroy.projectg.R
import com.techstroy.projectg.databinding.RecoverPasswordFragmentBinding

class RecoverPasswordFragment : Fragment() {

    companion object {
        fun newInstance() = RecoverPasswordFragment()
    }

    private lateinit var binding: RecoverPasswordFragmentBinding
    private lateinit var viewModel: RecoverPasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RecoverPasswordFragmentBinding.inflate(inflater)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecoverPasswordViewModel::class.java)
        // TODO: Use the ViewModel
    }

}