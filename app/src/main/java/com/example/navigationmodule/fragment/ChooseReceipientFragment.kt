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
import com.example.navigationmodule.databinding.FragmentChooseReceipientBinding

class ChooseReceipientFragment : Fragment(), View.OnClickListener{

    lateinit var binding:FragmentChooseReceipientBinding
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_choose_receipient, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.nextBtn.setOnClickListener(this)
        binding.cancelBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.nextBtn.id ->{
                if (!TextUtils.isEmpty(binding.inputRecipient.text.toString())){
                    val bundle = bundleOf("recipient" to binding.inputRecipient.text.toString())
                    navController.navigate(R.id.action_chooseReceipientFragment_to_specifyAmountFragment,
                    bundle)
                }
            }

            binding.cancelBtn.id ->{
                activity?.onBackPressed()
            }
        }
    }
}