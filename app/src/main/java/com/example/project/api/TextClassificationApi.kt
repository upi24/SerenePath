package com.example.project.api

import com.example.project.model.PredictionResult
import  retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface TextClassificationApi {
    @POST("predict")
    fun classifyText(@Query("text") text: String): Call<PredictionResult>
}