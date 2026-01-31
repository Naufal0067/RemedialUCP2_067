package com.example.remedialucp2.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblBuku")
data class Buku(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val judul: String,
    val pengarang: String,
    val kategori: String
)

