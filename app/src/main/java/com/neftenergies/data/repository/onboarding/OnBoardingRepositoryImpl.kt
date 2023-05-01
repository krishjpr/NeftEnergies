package com.neftenergies.data.repository.onboarding

import com.neftenergies.di.GramAppService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OnBoardingRepositoryImpl @Inject constructor(
    private val gramAppService: GramAppService
) : OnBoardingRepository {

    override suspend fun getLanguage(): Response<ResponseBody> = withContext(
        Dispatchers.IO
    ) {
        val appData = gramAppService.getLanguage()
        appData
    }




}