package com.example.firebasenotes.data

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("send_recovery.php")
    suspend fun sendRecoveryEmail(
        @Field("email") email: String
    ): Response<Unit>
}
