package br.com.dio.app.repositories.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner (
    val login: String,
    @SerializedName("avatar_url")
    val avatarURL: String
) : Parcelable
