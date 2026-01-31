package com.example.remedialucp2.room


import androidx.room.Entity

@Entity(
    tableName = "tblBukuPengarang",
    primaryKeys = ["bukuId", "nama_pengarang"]
)
data class Pengarang(
    val bukuId: Int,
    val nama_pengarang: String
)
