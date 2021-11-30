package com.example.learningapp

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapp.adapters.UsersAdapter
import com.example.learningapp.api.CallbackApiData
import com.example.learningapp.models.UserResponse
import com.example.learningapp.viewmodels.UserViewModel
import com.example.learningapp.viewmodelsfactories.UserViewModelFactory

class UsersActivity : AppCompatActivity(), CallbackApiData {
    lateinit var listOfUsers: MutableList<UserResponse>
    lateinit var userAdapter: UsersAdapter
    var recyclerView: RecyclerView? = null
    lateinit var viewModel: UserViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        recyclerView  = findViewById(R.id.recycler_view)

        listOfUsers = mutableListOf<UserResponse>()
        viewModel = ViewModelProvider(
            this,
            UserViewModelFactory(this)
        ).get(UserViewModel::class.java)

        userAdapter = UsersAdapter(this, listOfUsers)
        recyclerView?.adapter = userAdapter
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onResponseCallback(type: Any) {

        viewModel.getDataOfUsers().observe(
            this,
            { t ->
                listOfUsers.clear()
                t?.let { listOfUsers.addAll(it) }
                userAdapter.addData(listOfUsers)
                userAdapter.notifyDataSetChanged()
            }
        )
    }
}