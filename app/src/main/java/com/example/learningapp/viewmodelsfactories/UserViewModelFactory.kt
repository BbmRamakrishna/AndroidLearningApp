package com.example.learningapp.viewmodelsfactories

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.learningapp.viewmodels.UserViewModel

class UserViewModelFactory(private val context: Context) : ViewModelProvider.NewInstanceFactory() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(context) as T
    }
}