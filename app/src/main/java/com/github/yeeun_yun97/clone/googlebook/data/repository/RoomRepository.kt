package com.github.yeeun_yun97.clone.googlebook.data.repository

import androidx.lifecycle.LiveData
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData
import com.github.yeeun_yun97.clone.googlebook.data.room.FavRoom

class RoomRepository {
    private val dao = FavRoom.getDao()

    fun loadAllFav(): LiveData<List<BookData>> {
        return dao.readAllFav()
    }

    fun loadFavById(id: Long): BookData {
        return dao.readFavById(id)
    }

    fun updateFav(fav: BookData) {
        dao.updateFav(fav)
    }

    fun deleteFav(fav: BookData) {
        dao.deleteFavByCode(fav.code)
//        dao.deleteFav(fav)
    }

    fun insertFav(fav: BookData) {
        fav.saved = true
        dao.insertFav(fav)
    }

    fun checkIfBookExists(code: String): Boolean {
        if (dao.readFavByCode(code) != null) {
            return true
        }
        return false
    }

}