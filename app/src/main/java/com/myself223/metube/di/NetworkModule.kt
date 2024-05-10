package com.salievYT.metube.di

import com.myself223.metube.BuildConfig.BASE_URL
import com.myself223.metube.BuildConfig.DEBUG
import com.myself223.metube.data.network.Remote.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val netModule = module{
    single { provideApiService(provideRetrofit(provideOkhttpBuilder().build())) }

}

fun provideRetrofit(client: OkHttpClient) : Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideApiService(retrofit: Retrofit) : ApiService {
    return retrofit.create(ApiService::class.java)
}

fun provideOkhttpBuilder() : OkHttpClient.Builder = OkHttpClient()
    .newBuilder()
    .addInterceptor(provideInterceptor())
    .callTimeout(60,TimeUnit.SECONDS)
    .connectTimeout(60,TimeUnit.SECONDS)
    .readTimeout(60,TimeUnit.SECONDS)
    .writeTimeout(60,TimeUnit.SECONDS)

private fun provideInterceptor() = HttpLoggingInterceptor().setLevel(
    when{
        DEBUG -> HttpLoggingInterceptor.Level.BODY
        else -> HttpLoggingInterceptor.Level.NONE
    }

)

