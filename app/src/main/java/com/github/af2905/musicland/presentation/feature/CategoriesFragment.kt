package com.github.af2905.musicland.presentation.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.musicland.databinding.FragmentCategoriesBinding
import com.github.af2905.musicland.di.DependencyInjector
import com.github.af2905.musicland.presentation.base.UiState
import com.github.af2905.musicland.presentation.widget.adapter.LoadingAdapter
import com.github.af2905.musicland.presentation.widget.adapter.delegate.CompositeDelegateAdapter
import com.github.af2905.musicland.presentation.widget.item.CategoryItem
import com.github.af2905.musicland.presentation.widget.item.LoadingItem
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
        setPresenter(CategoriesPresenter(this, DependencyInjector()))
        adapter = CompositeDelegateAdapter(
            CategoryAdapter(CategoryItem.VIEW_TYPE) { presenter.onOpenDetailClicked(it) },
            LoadingAdapter(LoadingItem.VIEW_TYPE)
        )
        recyclerView = binding.categoriesRecyclerView
        recyclerView.adapter = adapter
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
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
        Toast.makeText(requireContext(), item.name, Toast.LENGTH_SHORT).show()
    }

    override fun setPresenter(presenter: CategoriesContract.Presenter) {
        this.presenter = presenter
    }
}