package com.example.learningapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapp.R
import com.example.learningapp.models.UserResponse

class UsersAdapter(
    private val context: Context,
    private var list: MutableList<UserResponse>
) :
    RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {


    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        var userName: TextView? = null
        var zipCode: TextView? = null
        var latitude: TextView? = null
        var phone: TextView? = null
        var catchPhrase: TextView? = null
        var address: TextView? = null


        init {
            userName = view.findViewById(R.id.user_name)
            zipCode = view.findViewById(R.id.zip_code)
            latitude = view.findViewById(R.id.latitude)
            phone = view.findViewById(R.id.phone)
            catchPhrase = view.findViewById(R.id.catch_phrase)
            address = view.findViewById(R.id.address)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.users_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val userItem = list.get(position)
        holder.userName?.setText(userItem.username ?: "")
        holder.zipCode?.setText(userItem.address?.zipcode ?: "")
        holder.latitude?.setText(userItem.address?.geo?.lat ?: "")
        holder.phone?.setText(userItem.phone ?: "")
        holder.catchPhrase?.setText(userItem.company?.catchPhrase ?: "")
        holder.address?.text =
            "${userItem.address?.suite ?: ""}===${userItem.address?.street ?: ""}===${
                userItem.address?.city ?: ""
            }===${userItem.address?.zipcode ?: ""}===${userItem.address?.geo ?: ""}==="

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addData(data: MutableList<UserResponse>) {
        list = data
    }
}


