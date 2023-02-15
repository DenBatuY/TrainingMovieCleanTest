package com.batuy.trainingmovieclean.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.batuy.trainingmovieclean.R
import com.batuy.trainingmovieclean.databinding.FragmentDetailInfoBinding
import com.batuy.trainingmovieclean.databinding.FragmentFavouriteFilmsBinding
import com.batuy.trainingmovieclean.presentation.adapter.Adapter
import javax.inject.Inject


class FavouriteFilmsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: Adapter
    private val component by lazy {
        (requireActivity().application as MovieApp).component
    }

    private var _binding: FragmentFavouriteFilmsBinding? = null
    private val binding: FragmentFavouriteFilmsBinding
        get() = _binding ?: throw RuntimeException("FragmentFavouriteFilmsBinding is null")

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]
        adapter = Adapter()
        binding.recyclerView2.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView2.adapter = adapter

        viewModel.listFavouriteMovies.observe(viewLifecycleOwner) {
            // Log.d("test","FavouriteFilmsFragment  $it")
            adapter.submitList(it)
        }

        adapter.onClickListener = {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, DetailInfoFragment.newInstance(it))
                .addToBackStack(null)
                .commit()
        }
        adapter.onLongClickListener = { viewModel.deleteFavouriteMovie(it.id!!) }
    }

    companion object {

        fun newInstance() =
            FavouriteFilmsFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
