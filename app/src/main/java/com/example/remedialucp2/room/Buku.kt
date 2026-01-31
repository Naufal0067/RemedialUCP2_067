package com.example.remedialucp2.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblProgramStudi")
data class Buku(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val nama_programstudi : String
)
