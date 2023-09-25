package br.senai.sp.jandira.retrofit_reqres

import com.google.gson.annotations.SerializedName

data class BasrResponse<T>(
    @SerializedName("data")
    var data: T? = null
)
