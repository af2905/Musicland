package com.github.af2905.musicland.presentation.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.af2905.musicland.R
import com.github.af2905.musicland.di.DependencyInjector
import com.github.af2905.musicland.domain.interactor.BrowseInteractor
import com.github.af2905.musicland.presentation.base.MainContract
import com.github.af2905.musicland.presentation.base.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CategoriesFragment : Fragment(), MainContract.View {

    private lateinit var presenter: MainContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setPresenter(CategoriesPresenter(this, DependencyInjector()))
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    companion object {
        val TAG: String = CategoriesFragment::class.java.simpleName
    }

    override fun displayUiState(uiState: UiState) {
        when (uiState) {
            UiState.LOADING -> {
                Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
            }
            UiState.SUCCESS -> {
                Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
            }
            UiState.FAIL -> Toast.makeText(requireContext(), "fail", Toast.LENGTH_SHORT).show()
        }
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }
}