package com.leonamleite.marvelapi.model

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Any>,
    val total: Int
)