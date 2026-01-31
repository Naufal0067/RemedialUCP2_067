package com.example.remedialucp2.room


import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PengarangDao {

    @Query("SELECT * FROM tblBukuPengarang WHERE bukuId = :bukuId")
    fun getPengarangByBuku(bukuId: Int): Flow<List<Pengarang>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(data: Pengarang)

    @Delete
    suspend fun delete(data: Pengarang)
}
