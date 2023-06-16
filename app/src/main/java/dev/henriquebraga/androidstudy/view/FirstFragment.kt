package dev.henriquebraga.androidstudy.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import dev.henriquebraga.androidstudy.R
import dev.henriquebraga.androidstudy.databinding.FragmentFirstBinding
import dev.henriquebraga.androidstudy.model.Person

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val p = Person("Henrique")
        val bundle = bundleOf("personArg" to p)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_first_to_second, bundle)
        }
    }
}