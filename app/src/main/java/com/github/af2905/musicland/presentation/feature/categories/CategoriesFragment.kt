package com.github.af2905.musicland.presentation.feature.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.musicland.R
import com.github.af2905.musicland.databinding.FragmentCategoriesBinding
import com.github.af2905.musicland.di.DependencyInjector
import com.github.af2905.musicland.domain.interactor.BrowseInteractor
import com.github.af2905.musicland.presentation.base.UiState
import com.github.af2905.musicland.presentation.feature.playlists.PlaylistsFragment
import com.github.af2905.musicland.presentation.widget.adapter.delegate.CompositeDelegateAdapter
import com.github.af2905.musicland.presentation.widget.decorator.GridListItemDecorator
import com.github.af2905.musicland.presentation.widget.item.*
import com.github.af2905.musicland.presentation.widget.model.Model

class CategoriesFragment : Fragment(), CategoriesContract.View {

    private lateinit var presenter: CategoriesContract.Presenter

    private lateinit var binding: FragmentCategoriesBinding
    private lateinit var adapter: CompositeDelegateAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val browseInteractor = BrowseInteractor(DependencyInjector().browseRepository())
        setPresenter(CategoriesPresenter(this, lifecycleScope, browseInteractor))
        adapter = CompositeDelegateAdapter(
            LoadingDelegate(LoadingItem.VIEW_TYPE),
            GridListDelegate(
                viewType = GridListItem.VIEW_TYPE,
                adapter = {
                    CompositeDelegateAdapter(
                        CategoryDelegate(CategoryItem.VIEW_TYPE) { presenter.onOpenDetailClicked(it) }
                    )
                },
                decoration = {
                    GridListItemDecorator(
                        marginBottom = it.resources.getDimensionPixelSize(R.dimen.default_margin),
                        marginStart = it.resources.getDimensionPixelSize(R.dimen.default_margin),
                        marginEnd = it.resources.getDimensionPixelSize(R.dimen.default_margin),
                        spacing = it.resources.getDimensionPixelSize(R.dimen.default_margin_small)
                    )
                }
            )
        )
        recyclerView = binding.categoriesRecyclerView
        recyclerView.adapter = adapter
        presenter.onViewCreated()
    }

    companion object {
        val TAG: String = CategoriesFragment::class.java.simpleName
    }

    override fun displayUiState(uiState: UiState, list: List<Model>) {
        when (uiState) {
            UiState.LOADING -> adapter.submitList(list)
            UiState.SUCCESS -> adapter.submitList(list)
            UiState.FAIL -> Toast.makeText(requireContext(), "fail", Toast.LENGTH_SHORT).show()
        }
    }

    override fun forwardToDetail(item: CategoryItem) {
        val fragment = PlaylistsFragment.newInstance(item.id)

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, PlaylistsFragment.TAG)
            .addToBackStack(PlaylistsFragment.TAG)
            .commit()
    }

    override fun setPresenter(presenter: CategoriesContract.Presenter) {
        this.presenter = presenter
    }
}