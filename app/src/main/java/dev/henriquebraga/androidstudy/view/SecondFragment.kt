package dev.henriquebraga.androidstudy.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.henriquebraga.androidstudy.R
import dev.henriquebraga.androidstudy.databinding.FragmentSecondBinding
import dev.henriquebraga.androidstudy.model.Person

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        printValue()
        binding.fab.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun printValue() {
        val p = arguments?.get("personArg") as Person
        binding.textView1.text = p.name
    }

}