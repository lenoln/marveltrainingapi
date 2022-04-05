package com.leonamleite.marvelapi.model

data class BaseData<T>(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<T>,
    val total: Int
)