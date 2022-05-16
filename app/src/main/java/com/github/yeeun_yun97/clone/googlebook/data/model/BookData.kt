package com.github.yeeun_yun97.clone.googlebook.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookData(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "code") val code: String,
    @ColumnInfo(name = "publisher") val publisher: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "linkUrl") val linkUrl: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "publishedDate") val publishedDate: String,
    @ColumnInfo(name = "imageUrl") val imageUrl: String,
    @ColumnInfo(name = "saved") var saved: Boolean,
    )