package com.example.navigationcomponent_gr1.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent_gr1.R
import com.example.navigationcomponent_gr1.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {
   private lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGoToProfile.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
            findNavController().navigate(action)
        }

        binding.btnShowSnackbar.setOnClickListener {
//            Toast.makeText(requireContext(), "This is a toast", Toast.LENGTH_SHORT).show()
            Snackbar.make(binding.root,"This is a snackbar",Snackbar.LENGTH_LONG).show()

        }

        binding.btnShowAlertDialog.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(requireContext())
            alertDialogBuilder.setTitle("This is alertdialog title!")
            alertDialogBuilder.setMessage("This is alertdialog message!")
            alertDialogBuilder.setPositiveButton("Po") { dialog , which ->
                Snackbar.make(binding.root,"Butoni po u klikua",Snackbar.LENGTH_LONG).show()
            }
            alertDialogBuilder.setNegativeButton("Jo") { dialog , which ->
                Snackbar.make(binding.root,"Butoni jo u klikua",Snackbar.LENGTH_LONG).show()
            }
            alertDialogBuilder.show()
        }








    }


}