package nikitagorbatko.example.rickmorty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import nikitagorbatko.example.rickmorty.adapter.CharactersAdapter

class FragmentCharacters(val listener: CharactersAdapter.OnItemClickListener): Fragment() {
    private lateinit var viewModel: FragmentCharactersVM
    private lateinit var recyclerCharacters: RecyclerView
    private lateinit var progressBar: ProgressBar
    private val adapter = CharactersAdapter(listener)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this@FragmentCharacters)
            .get(FragmentCharactersVM::class.java)
        observe()
        val view = inflater.inflate(R.layout.fragment_characters, container, false)
        progressBar = view.findViewById(R.id.progressBar)
        recyclerCharacters = view.findViewById(R.id.recycler)
        recyclerCharacters.adapter = adapter
        recyclerCharacters.layoutManager = GridLayoutManager(context, 3)
        return view
    }

    private fun observe() {
        viewModel.getCharacters()

        viewModel.characters.observe(viewLifecycleOwner, Observer {
            progressBar.isVisible = false
            adapter.add(it)
        })
    }
}

