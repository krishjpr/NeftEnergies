package com.neftenergies.di

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*


interface GramAppService {

    @GET("api/v5/onboarding/get-language")
    @JvmSuppressWildcards
    suspend fun getLanguage(): Response<ResponseBody>

}
