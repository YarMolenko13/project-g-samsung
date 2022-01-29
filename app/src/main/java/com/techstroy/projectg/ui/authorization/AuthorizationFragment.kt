package com.techstroy.projectg.ui.authorization

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.techstroy.projectg.R
import com.techstroy.projectg.databinding.AuthorizationFragmentBinding

class AuthorizationFragment : Fragment() {

    private lateinit var binding: AuthorizationFragmentBinding
    private lateinit var viewModel: AuthorizationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AuthorizationFragmentBinding.inflate(inflater)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthorizationViewModel::class.java)

        binding.logIn.setOnClickListener {
            this.findNavController().navigate(
                AuthorizationFragmentDirections.actionAuthorizationFragmentToFeedFragment()
            )
        }

        binding.toRegistration.setOnClickListener {
            this.findNavController().navigate(
                AuthorizationFragmentDirections.actionAuthorizationFragmentToRegistrationFragment()
            )
        }

        binding.toForgotPassword.setOnClickListener {
            this.findNavController().navigate(
                AuthorizationFragmentDirections.actionAuthorizationFragmentToRecoverPasswordFragment()
            )
        }
    }
}