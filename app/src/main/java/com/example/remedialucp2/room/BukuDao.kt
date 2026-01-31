package com.example.remedialucp2.room


import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BukuDao {

    @Query("SELECT * FROM tblBuku ORDER BY id DESC")
    fun getAllBuku(): Flow<List<Buku>>

    @Query("SELECT * FROM tblBuku WHERE id = :id")
    fun getBuku(id: Int): Flow<Buku?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(buku: Buku)

    @Update
    suspend fun update(buku: Buku)

    @Delete
    suspend fun delete(buku: Buku)
}
