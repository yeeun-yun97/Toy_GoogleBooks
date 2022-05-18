package com.github.yeeun_yun97.clone.googlebook.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.github.yeeun_yun97.clone.googlebook.data.model.BookData

@Dao
interface FavDao {

    @Insert
    fun createFav(fav: BookData)

    @Query("SELECT * FROM BookData")
    fun readAllFav(): LiveData<List<BookData>>

    @Query("SELECT * FROM BookData WHERE id=:id")
    fun readFavById(id: Long): BookData

    @Update
    fun updateFav(fav: BookData)

    @Delete
    fun deleteFav(fav: BookData)

    @Query("DELETE FROM BookData WHERE code=:code")
    fun deleteFavByCode(code: String)

    @Insert
    fun insertFav(fav: BookData)

    @Query("SELECT * FROM BookData WHERE code = :code")
    fun readFavByCode(code: String): BookData?


}