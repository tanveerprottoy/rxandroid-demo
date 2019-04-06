package com.tanveershafeeprottoy.rxandroiddemo

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Tanveer Prottoy
 */
private const val TIMEOUT = 60

class NetUtils {

    //kotlin way, lazy is thread safe, synchronized, double lock
    companion object {
        val retrofit: Retrofit by lazy {
            Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .client(
                    OkHttpClient.Builder()
                        .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                        .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                        .writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                        .addInterceptor(
                            HttpLoggingInterceptor().setLevel(
                                HttpLoggingInterceptor.Level.BODY
                            )
                        )
                        .build()
                )
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }
}