package com.github.yeeun_yun97.clone.googlebook.viewModel.ListBookViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.yeeun_yun97.clone.googlebook.data.BookRepository
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListBookViewModel : ViewModel() {

    val repository = BookRepository()

    val bookList: LiveData<List<BookData>> get() = _bookList
    private val _bookList = MutableLiveData<List<BookData>>(listOf())

    init {
        val books= mutableListOf<BookData>()
        for (i in 1..10) {
            val book = BookData(
                author = "작가" + i,
                publisher = "출판사" + i,
                title = "제목" + i,
                linkUrl = "링크" + i,
                publishedDate = "날짜" + i,
                imageUrl = "이미지" + i
            )
            books.add(book)
        }
        _bookList.postValue(books)
        loadBooks()
    }
    private fun loadBooks(){
        viewModelScope.launch(Dispatchers.IO){
            val list = repository.getBooks()
            _bookList.postValue(list)
        }
    }
}