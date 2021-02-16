package nikitagorbatko.example.rickmorty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso

class FragmentPerson(character: Character): Fragment() {
    private val person = character

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_person, container, false)
        Picasso.get().load(person.image).into(view.findViewById<ImageView>(R.id.image_person))
        val episodes = ""
        for (item in person.episode!!) {
            episodes.plus(item + " ")
        }
        view.findViewById<TextView>(R.id.text_person_name).text = person.name
        view.findViewById<TextView>(R.id.text_status).text = person.status
        view.findViewById<TextView>(R.id.text_species).text = person.species
        view.findViewById<TextView>(R.id.text_type).text = person.type
        view.findViewById<TextView>(R.id.text_gender).text = person.gender
        view.findViewById<TextView>(R.id.text_episode).text = episodes
        view.findViewById<TextView>(R.id.text_created).text = person.created?.substring(0,10)
        return view
    }


}