package com.example.koinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.koinexample.model.GithubUser
import com.example.koinexample.util.LoadingState
import com.example.koinexample.util.UserListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel by viewModel<UserViewModel>()
    private lateinit var progressBar: ProgressBar
    private lateinit var rvGithubUsers: RecyclerView
    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        rvGithubUsers = findViewById(R.id.rvGithubUsers)

        rvGithubUsers.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        adapter = UserListAdapter()
        rvGithubUsers.adapter = adapter

        userViewModel.data.observe(this, Observer {
            adapter.addAll(it as ArrayList<GithubUser>)
        })

        userViewModel.loadingState.observe(this, Observer {
            when (it) {
                LoadingState.LOADED -> progressBar.visibility = View.GONE
                LoadingState.LOADING -> progressBar.visibility = View.VISIBLE
                else -> progressBar.visibility = View.GONE
            }
        })
    }
}