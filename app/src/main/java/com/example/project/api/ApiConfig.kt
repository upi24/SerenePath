package com.example.project.api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    private const val BASE_URL = "https://serenepath-ml-api-pe33umidqq-et.a.run.app/"

    val textClassificationApi: TextClassificationApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TextClassificationApi::class.java)
    }
}