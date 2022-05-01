package com.github.yeeun_yun97.clone.googlebook.data.model

data class SearchBooks(
    //val kind: String,
    //val totalItems: Int,
    val items: List<Book>
    )

data class Book(
   // val kind: String,
   // val id: String,
   // val etag:String,
   // val selfLink:String,
    val volumeInfo:VolumeInfo,
    //val saleInfo:Map<String,String>,
    //val accessInfo:Map<String,String>,
   // val searchInfo:Map<String,String>
)
data class VolumeInfo(
    val title:String?,
    val authors:List<String>?,
    val publisher:String?,
    val publishedDate:String?,
   // val description:String,
    //val industryIdentifiers:List<Map<String,String>>,
    //val readingModes:Map<String,String>,
   // val printType:String,
   // val categories:List<String>,
   // val maturityRating:String,
   // val allowAnonLogging:Boolean,
   // val contentVersion:String,
   // val panelizationSummary:Map<String,String>,
    val imageLinks :Map<String,String>?,
   // val language:String,
   // val previewLink:String,
    val infoLink:String?,
    //val canonicalVolumeLnk:String
)