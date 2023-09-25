package br.senai.sp.jandira.retrofit_reqres

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("api/users/{id}")
    suspend fun getUserById(@Path("id") id: String): Response<BasrResponse<UserResponse>>

    @POST("api/user/")
    suspend fun createUser(@Body body: JsonObject) : Response<JsonObject>

    @PUT("api/user/{id}")
    suspend fun updateUser(@Path("id") id: String, @Body body: JsonObject): Response<JsonObject>


    @DELETE("api/user/{id}")
    suspend fun deleteUser(@Path("id") id: String): Response<BasrResponse<UserResponse>>

}

