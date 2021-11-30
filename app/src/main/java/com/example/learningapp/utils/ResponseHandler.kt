package com.example.learningapp.utils

import android.R
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout

object ResponseHandler {

    private var progressBar: ProgressBar? = null

    fun Context.isInternetAvailable(): Boolean {

        try {

            val connectivityManager =
                getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo

            if (networkInfo != null && networkInfo.isConnected) {
                return true
            } else {
                showErrorToast("Internet not available. Please try again!!")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return false
    }

    private fun Context.showErrorToast(message: String) {

        try {
            val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
            val textView = toast.view?.findViewById(android.R.id.message) as? TextView

            textView?.setTextColor(Color.BLACK)
            textView?.gravity = Gravity.CENTER

            toast.view?.setBackgroundColor(Color.TRANSPARENT)
            toast.setGravity(Gravity.TOP or Gravity.FILL_HORIZONTAL, 0, 0)

            toast.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun Context.showProgressBar() {

        try {

            val layout =
                (this as? Activity)?.findViewById<View>(android.R.id.content)?.rootView as ViewGroup

            progressBar = ProgressBar(this, null, R.attr.progressBarStyleLarge)

            progressBar.let { it ->
                it?.isIndeterminate = true
                val params = ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.MATCH_PARENT,
                    ConstraintLayout.LayoutParams.MATCH_PARENT,
                )

                val constraintLayout = ConstraintLayout(this)
                constraintLayout.foregroundGravity = Gravity.CENTER
                constraintLayout.addView(it)

                layout.addView(constraintLayout, params)
                it?.visibility = View.VISIBLE

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hideProgressBar() {
        try {
            progressBar.let {
                it?.visibility = View.GONE
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}