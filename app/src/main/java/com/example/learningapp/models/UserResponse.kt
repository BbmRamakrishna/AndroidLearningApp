package com.example.learningapp.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class UserResponse(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("address") var address: Address? = Address(),
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("website") var website: String? = null,
    @SerializedName("company") var company: Company? = Company()

) : Serializable


data class Geo(

    @SerializedName("lat") var lat: String? = null,
    @SerializedName("lng") var lng: String? = null

) : Serializable


data class Company(

    @SerializedName("name") var name: String? = null,
    @SerializedName("catchPhrase") var catchPhrase: String? = null,
    @SerializedName("bs") var bs: String? = null

) : Serializable

data class Address(

    @SerializedName("street") val street: String? = null,
    @SerializedName("suite") val suite: String? = null,
    @SerializedName("city") val city: String? = null,
    @SerializedName("zipcode") val zipcode: String? = null,
    @SerializedName("geo") val geo: Geo? = null
) : Serializable