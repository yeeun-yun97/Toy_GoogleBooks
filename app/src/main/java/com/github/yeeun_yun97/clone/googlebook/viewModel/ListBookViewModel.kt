package com.github.yeeun_yun97.clone.googlebook.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.yeeun_yun97.clone.googlebook.data.repository.BookRepository
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListBookViewModel : ViewModel() {

    private val repository = BookRepository.newInstance()

    val bookList: LiveData<List<BookData>> get() = _bookList
    private val _bookList = MutableLiveData<List<BookData>>(listOf())

    fun loadBooks(){
        viewModelScope.launch(Dispatchers.IO){
            val list = repository.getBooks()
            _bookList.postValue(list)
        }
    }
}