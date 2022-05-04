package com.github.yeeun_yun97.clone.googlebook.data.model

data class SearchBooks(
    val items: List<Book>
    /*
    val kind: String,
    val totalItems: Int,
    */
)

data class Book(
    val volumeInfo: VolumeInfo,
    val id: String,
    /*
    val kind: String,
    val etag: String,
    val selfLink: String,
    val saleInfo: Map<String, String>,
    val accessInfo: Map<String, String>,
    val searchInfo: Map<String, String>
    */
)

data class VolumeInfo(
    val title: String?,
    val authors: List<String>?,
    val publisher: String?,
    val publishedDate: String?,
    val imageLinks: Map<String, String>?,
    val infoLink: String?,
    /*
    val industryIdentifiers: List<Map<String, String>>,
    val description: String,
    val readingModes: Map<String, String>,
    val printType: String,
    val categories: List<String>,
    val maturityRating: String,
    val allowAnonLogging: Boolean,
    val contentVersion: String,
    val panelizationSummary: Map<String, String>,
    val language: String,
    val previewLink: String,
    val canonicalVolumeLnk: String
    */
)