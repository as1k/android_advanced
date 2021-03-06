package com.example.cleanarchsample.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchsample.databinding.FragmentRepoListBinding
import com.example.cleanarchsample.ui.adapter.RepoListAdapter
import com.example.cleanarchsample.viewmodel.RepoListViewModel
import kotlinx.android.synthetic.main.fragment_repo_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepoListFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentRepoListBinding
    private lateinit var adapter: RepoListAdapter
    private val repoListViewModel: RepoListViewModel by viewModel()
    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        increaseCounter()
        viewDataBinding = FragmentRepoListBinding.inflate(inflater, container, false).apply {setLifecycleOwner(viewLifecycleOwner) }

        viewDataBinding.viewmodel = repoListViewModel
        return viewDataBinding.root
    }

    fun increaseCounter(){
        counter+=1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchRepoList()
        increaseCounter()
        setupAdapter()
        setObservers()
    }


    private fun setObservers() {
        increaseCounter()
        viewDataBinding.viewmodel?.fetchRepoList()?.observe(viewLifecycleOwner, Observer { adapter.updateRepoList(it) })

//        viewDataBinding.viewmodel.toastMessage.observe(viewLifecycleOwner, Observer {
//            activity?.longToast(it)
//        })
    }

    private fun setupAdapter() {
        increaseCounter()
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = RepoListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager
            repo_list_rv.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            repo_list_rv.adapter = adapter
        }
    }

}