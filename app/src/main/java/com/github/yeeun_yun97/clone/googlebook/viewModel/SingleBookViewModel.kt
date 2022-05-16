package com.github.yeeun_yun97.clone.googlebook.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import com.github.yeeun_yun97.clone.googlebook.data.repository.RoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SingleBookViewModel : ViewModel() {
    private val roomRepository = RoomRepository()
    val book = MutableLiveData<BookData>()

    fun saveFav(){
        val bookData =book.value!!
        viewModelScope.launch(Dispatchers.IO) {
            if(bookData.saved){
                roomRepository.deleteFav(bookData)
            }else{
                roomRepository.insertFav(bookData)
            }
        }
        book.postValue(bookData.copy(saved=!bookData.saved))
        Log.d("updated book Data fav", bookData.saved.toString())
    }
}