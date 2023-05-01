package com.neftenergies.data.repository.onboarding

import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Singleton

@Singleton
interface OnBoardingRepository {

    suspend fun getLanguage(): Response<ResponseBody>

}