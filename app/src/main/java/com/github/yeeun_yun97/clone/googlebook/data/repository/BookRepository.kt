package com.github.yeeun_yun97.clone.googlebook.data.repository

import android.util.Log
import com.github.yeeun_yun97.clone.googlebook.data.retrofit.GoogleBooksService
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData

class BookRepository private constructor() {
    private val service = GoogleBooksService.newInstance()

    companion object {
        private lateinit var repo: BookRepository
        fun newInstance(): BookRepository {
            if (!this::repo.isInitialized) {
                repo = BookRepository()
            }
            return repo
        }
    }

    suspend fun getBooks(): List<BookData> {
        val list = mutableListOf<BookData>()
        val response = service.searchBookByName("프로그래밍")
        if (!response.isSuccessful) {
            Log.d("실패", response.code().toString())
            Log.d("실패", response.errorBody()!!.string())
        } else {
            for (book in response!!.body()!!.items) {
                val author =
                    if (book.volumeInfo.authors == null || book.volumeInfo.authors.size == 0) {
                        ""
                    } else {
                        book.volumeInfo.authors[0]
                    }
                val imageUrl: String =
                    if (book.volumeInfo.imageLinks == null || book.volumeInfo.imageLinks.values.size == 0) {
                        ""
                    } else {
                        book.volumeInfo.imageLinks.values.random()
                    }
                val bookData = BookData(
                    author = author,
                    code = book.id,
                    publisher = book.volumeInfo.publisher ?: "",
                    title = book.volumeInfo.title ?: "",
                    linkUrl = book.volumeInfo.canonicalVolumeLink ?: "",
                    publishedDate = book.volumeInfo.publishedDate ?: "",
                    imageUrl = imageUrl,
                    saved = false
                )
                list.add(bookData)
            }
            return list
        }
        return listOf()
    }

}