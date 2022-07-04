package br.com.dio.app.repositories.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Repo (
    val id: Long,
    val name: String,
    val owner: Owner,
    @SerializedName("stargazers_count")
    val stargazersCount: Long?,
    val language: String?,
    @SerializedName("html_url")
    val htmlURL: String?,
    val description: String?
) : Parcelable


