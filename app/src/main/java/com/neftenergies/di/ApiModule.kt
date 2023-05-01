package com.neftenergies.di

import com.neftenergies.BuildConfig
import com.neftenergies.utils.Constants
import com.neftenergies.utils.SharedPreferencesHelper
import com.neftenergies.utils.SharedPreferencesKeys
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(getHeaderInterceptor())
            .addInterceptor(logging)
            .connectTimeout(60, TimeUnit.SECONDS) // connect timeout
            .readTimeout(70, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    @Named("mobility")
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    @Named("community")
    fun provideRetrofitCommunity(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideGramAppSocialService(@Named("community") retrofit: Retrofit): GramAppService {
        return retrofit.create(GramAppService::class.java)
    }

    private fun getHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request =
                chain.request().newBuilder()
                    .header(
                        Constants.AUTHORIZATION,
                        "Bearer " + SharedPreferencesHelper.instance?.getString(
                            SharedPreferencesKeys.session_token
                        )!!
                    )
                    .build()
            chain.proceed(request)
        }
    }
}