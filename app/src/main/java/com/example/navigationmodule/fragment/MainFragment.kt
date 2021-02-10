package com.example.navigationmodule.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationmodule.R
import com.example.navigationmodule.databinding.FragmentMainBinding

class MainFragment : Fragment(), View.OnClickListener{

    lateinit var binding:FragmentMainBinding
    lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.sendMoneyBtn.setOnClickListener(this)
        binding.viewBalanceBtn.setOnClickListener(this)
        binding.viewTransactionsBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.sendMoneyBtn.id ->{
                navController.navigate(R.id.action_mainFragment_to_chooseReceipientFragment)
            }

            binding.viewBalanceBtn.id ->{
                navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
            }

            binding.viewTransactionsBtn.id ->{
                navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
            }
        }
    }
}