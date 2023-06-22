package dev.henriquebraga.androidstudy.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import dev.henriquebraga.androidstudy.databinding.ItemListBinding
import dev.henriquebraga.androidstudy.model.Person
import dev.henriquebraga.androidstudy.utils.OnItemClickListener

class PersonListAdapter (
    list: List<Person>,
    private val listener: OnItemClickListener
): RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {

    // AsyncListDiffer
    private val asyncListDiffer: AsyncListDiffer<Person> = AsyncListDiffer(this, DiffCallback)

    init {
        asyncListDiffer.submitList(list)
    }


    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): PersonListAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonListAdapter.ViewHolder, position: Int) {
        holder.bind(asyncListDiffer.currentList[position])
    }

    override fun getItemCount(): Int = asyncListDiffer.currentList.size

    fun submitList(persons: List<Person>) {
        asyncListDiffer.submitList(persons)
    }

    inner class ViewHolder(
        private val binding: ItemListBinding
    ) :RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) {
            binding.textView2.text = person.name
            binding.root.setOnClickListener {
                listener.onItemClick(person)
            }
        }
    }

    // DiffCallback
    object DiffCallback : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.name == newItem.name
        }

    }

}