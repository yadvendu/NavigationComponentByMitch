package com.example.navigationmodule.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationmodule.R
import com.example.navigationmodule.databinding.FragmentSpecifyAmountBinding
import com.example.navigationmodule.model.Money
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentSpecifyAmountBinding
    lateinit var navController: NavController
    private var recipient: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_specify_amount, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.sendBtn.setOnClickListener(this)
        binding.cancelBtn.setOnClickListener(this)

        val message = "Sending money to $recipient"
        binding.recipient.text = message
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.sendBtn.id -> {
                if (!TextUtils.isEmpty(binding.inputAmount.text.toString())) {
                    val amount = Money(BigDecimal(binding.inputAmount.text.toString()))
                    val bundle = bundleOf(
                        "recipient" to recipient,
                        "money" to amount
                    )
                    navController.navigate(
                        R.id.action_specifyAmountFragment_to_confirmationFragment,
                        bundle
                    )
                }
            }

            binding.cancelBtn.id -> {
                activity?.onBackPressed()
            }
        }
    }
}