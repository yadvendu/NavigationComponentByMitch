package com.example.navigationmodule.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.navigationmodule.R
import com.example.navigationmodule.databinding.FragmentConfirmationBinding
import com.example.navigationmodule.model.Money

class ConfirmationFragment : Fragment() {
    lateinit var binding: FragmentConfirmationBinding
    private var recipient: String? = null
    private var amount:Money? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient")
        amount = arguments?.getParcelable<Money>("money")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_confirmation, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val message = "You have sent Rs${amount?.amount} to $recipient"
        binding.confirmationMessage.text = message
    }
}