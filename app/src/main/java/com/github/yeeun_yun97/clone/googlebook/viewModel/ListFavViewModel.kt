package com.github.yeeun_yun97.clone.googlebook.viewModel

import androidx.lifecycle.ViewModel
import com.github.yeeun_yun97.clone.googlebook.data.repository.RoomRepository

class ListFavViewModel : ViewModel(){
    val repository = RoomRepository()
    val favList = repository.loadAllFav()


}