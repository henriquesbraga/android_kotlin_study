package dev.henriquebraga.androidstudy.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dev.henriquebraga.androidstudy.R
import dev.henriquebraga.androidstudy.databinding.FragmentFirstBinding
import dev.henriquebraga.androidstudy.model.Person
import dev.henriquebraga.androidstudy.utils.OnItemClickListener
import dev.henriquebraga.androidstudy.utils.SpaceItemDecorator
import dev.henriquebraga.androidstudy.utils.personDataList

class FirstFragment : Fragment(), OnItemClickListener{

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: PersonListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = PersonListAdapter(personDataList, this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Setup adapter
        binding.recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView1.adapter = adapter
        binding.recyclerView1.addItemDecoration(SpaceItemDecorator(18))

        //Setup listeners
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_first_to_second)
        }
    }

    override fun onItemClick(person: Person) {
        val snackbar = Snackbar.make(binding.root, "Name: ${person.name}", Snackbar.LENGTH_SHORT)
        snackbar.show()
    }

}

