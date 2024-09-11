package com.unlam.marvel.data

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.unlam.marvel.databinding.ListItemCharacterBinding
import com.unlam.marvel.domain.Hero

class HeroViewHolder(private val binding: ListItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(hero: Hero) {
        binding.name.text = hero.name
        binding.description.text = hero.description

        if (hero.thumbnailUrl.isNotEmpty()) {
            Picasso.get()
                .load(hero.thumbnailUrl)
                .into(binding.image)
        } else {
            binding.image.setImageURI(null)
        }
    }

}
