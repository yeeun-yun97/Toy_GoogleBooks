package com.github.yeeun_yun97.clone.googlebook.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import com.github.yeeun_yun97.clone.googlebook.data.repository.BookRepository
import com.github.yeeun_yun97.clone.googlebook.data.repository.RoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    private val repository = BookRepository.newInstance()
    private val roomRepository = RoomRepository()

    val favList = roomRepository.loadAllFav()

    val bookList: LiveData<List<BookData>> get() = _bookList
    private val _bookList = MutableLiveData<List<BookData>>(listOf())

    fun loadBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = repository.getBooks()
            launch(Dispatchers.Default){
                for(book in list){
                    if(roomRepository.checkIfBookExists(book.code)){
                        book.saved=true
                    }
                }
            }
            _bookList.postValue(list)
        }
    }

    fun saveFav(fav: BookData, isAdd: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            if (isAdd) {
                roomRepository.insertFav(fav)
            } else {
                roomRepository.deleteFav(fav)
            }
        }
    }
}