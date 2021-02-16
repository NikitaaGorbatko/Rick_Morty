package nikitagorbatko.example.rickmorty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import nikitagorbatko.example.rickmorty.Character
import nikitagorbatko.example.rickmorty.R


class CharactersAdapter(private val listener: OnItemClickListener): RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {
    private val charactersCopy = ArrayList<Character>()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_character)
        val name: TextView = view.findViewById(R.id.text_name)
        private val v = view

        fun setListener(listener: OnItemClickListener, character: Character) {
            v.setOnClickListener { listener.onItemClick(character) }
        }
    }

    fun add(new: ArrayList<Character>) {
        charactersCopy.addAll(new)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_character, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setListener(listener, charactersCopy[position])
        Picasso.get().load(charactersCopy[position].image).into(holder.image)
        holder.name.text = charactersCopy[position].name
    }

    //TODO diffutil

    override fun getItemCount(): Int = charactersCopy.size

    fun interface OnItemClickListener {
        fun onItemClick(character: Character)
    }
}
