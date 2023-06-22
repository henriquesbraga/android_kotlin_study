package dev.henriquebraga.androidstudy.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dev.henriquebraga.androidstudy.R
import dev.henriquebraga.androidstudy.databinding.FragmentSecondBinding
import dev.henriquebraga.androidstudy.model.Person
import dev.henriquebraga.androidstudy.utils.OnItemClickListener
import dev.henriquebraga.androidstudy.utils.SpaceItemDecorator
import dev.henriquebraga.androidstudy.utils.personDataList

class SecondFragment : Fragment(), OnItemClickListener {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: PersonListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = PersonListAdapter(personDataList.shuffled(), this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Adapter
        //Setup adapter
        binding.recyclerView2.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView2.adapter = adapter
        binding.recyclerView2.addItemDecoration(SpaceItemDecorator(18))

        // Setup Listeners
        binding.fab.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onItemClick(person: Person) {
        val snackbar = Snackbar.make(binding.root, "Name: ${person.name}", Snackbar.LENGTH_SHORT)
        snackbar.show()
    }


}