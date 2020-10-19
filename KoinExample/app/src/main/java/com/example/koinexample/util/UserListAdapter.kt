package com.example.koinexample.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.koinexample.R
import com.example.koinexample.model.GithubUser
import com.squareup.picasso.Picasso

class UserListAdapter() : RecyclerView.Adapter<UserListAdapter.UserHolder>() {

    val list: ArrayList<GithubUser> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_user,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class UserHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var userAvatar: ImageView
        var userLogin: TextView
        var userId: TextView

        init {
            userAvatar = itemview.findViewById(R.id.userAvatar)
            userLogin = itemview.findViewById(R.id.userLogin)
            userId = itemview.findViewById(R.id.userId)
        }

        fun bind(user: GithubUser) = with(itemView) {
            Picasso.get().load(user.avatar_url).into(userAvatar)
            userLogin.text = user.login
            userId.text = "User id: ${user.id}"
        }
    }

    fun addAll(newList: ArrayList<GithubUser>) {
        this.list.clear()
        this.list.addAll(newList)
        notifyDataSetChanged()
    }
}
