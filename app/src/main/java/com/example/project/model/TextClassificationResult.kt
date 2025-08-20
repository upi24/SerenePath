package com.example.project.model
import com.example.project.model.PredictionResult

data class TextClassificationResult(
    val msg: Message // Gantilah dengan nama yang sesuai
)

data class Message(
    val Label: String,
    val Probability: Double
    // tambahkan properti lainnya sesuai kebutuhan
)