package dev.henriquebraga.androidstudy.utils

import dev.henriquebraga.androidstudy.model.Person

interface OnItemClickListener {
  fun onItemClick(person: Person)
}