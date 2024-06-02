package com.army.info.data

import java.io.Serializable

data class TestModel(
    val category: Int,
    val subCategory: String,
    val index: Int,
    val question: String,
    val answer: String,
) : Serializable
