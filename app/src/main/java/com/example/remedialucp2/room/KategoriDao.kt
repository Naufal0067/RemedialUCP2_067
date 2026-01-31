package com.example.remedialucp2.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface KategoriDao {

    @Query("SELECT * FROM tblKategori ORDER BY id DESC")
    fun getAllKategori(): Flow<List<Kategori>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(kategori: Kategori)

    @Update
    suspend fun update(kategori: Kategori)

    @Delete
    suspend fun delete(kategori: Kategori)
}
