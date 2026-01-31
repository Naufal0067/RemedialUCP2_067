package com.example.remedialucp2.room


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblKategori")
data class Kategori(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama_kategori: String,
    val parent_id: Int? = null
)
