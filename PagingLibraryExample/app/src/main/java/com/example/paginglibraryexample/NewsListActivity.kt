package com.example.paginglibraryexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.paginglibraryexample.adapter.NewsListAdapter
import com.example.paginglibraryexample.model.State
import com.example.paginglibraryexample.view_model.NewsListViewModel
import kotlinx.android.synthetic.main.activity_news_list.*
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.ViewModelProvider

class NewsListActivity : AppCompatActivity() {

    private lateinit var viewModel: NewsListViewModel
    private lateinit var newsListAdapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)

        viewModel = ViewModelProvider(this).get(NewsListViewModel::class.java)
        initAdapter()
        initState()
    }

    private fun initAdapter() {
        newsListAdapter = NewsListAdapter { viewModel.retry() }
        recycler_view.adapter = newsListAdapter
        viewModel.newsList.observe(this,
            Observer {
                newsListAdapter.submitList(it)
            })
    }

    private fun initState() {
        txt_error.setOnClickListener { viewModel.retry() }
        viewModel.getState().observe(this, Observer { state ->
            progress_bar.visibility = if (viewModel.listIsEmpty() && state == State.LOADING) VISIBLE else GONE
            txt_error.visibility = if (viewModel.listIsEmpty() && state == State.ERROR) VISIBLE else GONE
            if (!viewModel.listIsEmpty()) {
                newsListAdapter.setState(state ?: State.DONE)
            }
        })
    }

}