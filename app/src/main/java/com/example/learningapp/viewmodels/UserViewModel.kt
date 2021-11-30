package com.example.learningapp.viewmodels

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learningapp.api.CallbackApiData
import com.example.learningapp.models.UserResponse
import com.example.learningapp.repositories.UserRepository
import com.example.learningapp.utils.ResponseHandler.isInternetAvailable

@RequiresApi(Build.VERSION_CODES.M)
class UserViewModel(private val context: Context) : ViewModel() {

    var userListData = MutableLiveData<ArrayList<UserResponse>>()

    init {

        if (context.isInternetAvailable()) {
            UserRepository.callbackApiData = context as CallbackApiData
            userListData = UserRepository.getMutableLiveData(context)
        }
    }

    fun getDataOfUsers(): MutableLiveData<ArrayList<UserResponse>> {
        return userListData
    }

}