package com.example.myapp.core.model.data

import kotlinx.datetime.Instant

/*
 * Project: MyApplication
 * File: NewsResource
 *
 * Created by: charvin on 8/30/24.
 * Last modified by: charvin on 8/30/24.
 *
 * Description:
 * 
 */
data class NewsResource(
    val id: String,
    val title: String,
    val content: String,
    val url: String,
    val headerImageUrl: String?,
    val publishDate: Instant,
    val type: String,
    val topics: List<Topic>,
)
