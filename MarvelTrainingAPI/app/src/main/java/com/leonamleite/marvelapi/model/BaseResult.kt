package com.leonamleite.marvelapi.model

import com.google.gson.annotations.SerializedName

data class BaseResult<T>(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    @SerializedName("data")
    val baseData: BaseData<T>,
    val etag: String,
    val status: String
)