package com.example.cleanarchsample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchsample.data.model.Item
import com.example.cleanarchsample.databinding.ViewRepoListBinding
import com.example.cleanarchsample.BR
import com.example.cleanarchsample.viewmodel.RepoListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_repo_list.view.*

class RepoListAdapter(private val repoListViewModel: RepoListViewModel) :
    RecyclerView.Adapter<RepoListAdapter.RepoListViewHolder>() {
    var repoList: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewRepoListBinding.inflate(inflater, parent, false)
        return RepoListViewHolder(dataBinding, repoListViewModel)
    }

    override fun getItemCount() = repoList.size

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.setup(repoList[position])
    }

    fun updateRepoList(repoList: List<Item>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }

    inner class RepoListViewHolder constructor(
        private val dataBinding: ViewDataBinding,
        private val repoListViewModel: RepoListViewModel
    ) : RecyclerView.ViewHolder(dataBinding.root) {

        val avatarImage = itemView.item_avatar
        fun setup(itemData: Item) {
            dataBinding.setVariable(BR.itemData, itemData)
            dataBinding.executePendingBindings()

            Picasso.get().load(itemData.owner.avatar_url).into(avatarImage);

//        itemView.onClick {
//            val bundle = bundleOf("url" to itemData.html_url)
//            itemView.findNavController()
//                .navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)
//        }
        }
    }
}