package com.example.learningapp.repositories

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.example.learningapp.api.ApiClient
import com.example.learningapp.api.CallbackApiData
import com.example.learningapp.models.UserResponse
import com.example.learningapp.utils.ResponseHandler.hideProgressBar
import com.example.learningapp.utils.ResponseHandler.showProgressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository() {


    companion object {
        lateinit var callbackApiData: CallbackApiData

        @RequiresApi(Build.VERSION_CODES.M)
        fun getMutableLiveData(context: Context): MutableLiveData<ArrayList<UserResponse>> {

            val mutableLiveData = MutableLiveData<ArrayList<UserResponse>>()
            context.showProgressBar()

            ApiClient.apiService.getUsers().enqueue(object : Callback<MutableList<UserResponse>> {
                override fun onResponse(
                    call: Call<MutableList<UserResponse>>,
                    response: Response<MutableList<UserResponse>>
                ) {
                    val usersResponse = response.body()
                    usersResponse.let {
                        mutableLiveData.value = it as ArrayList<UserResponse>
                    }
                    hideProgressBar()
                    callbackApiData.onResponseCallback(mutableLiveData)
                }

                override fun onFailure(call: Call<MutableList<UserResponse>>, t: Throwable) {
                    hideProgressBar()
                    Log.e("Error", t.localizedMessage)
                }

            })
            return mutableLiveData
        }
    }


}