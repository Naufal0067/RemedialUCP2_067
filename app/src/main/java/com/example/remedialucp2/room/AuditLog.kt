package com.example.remedialucp2.room


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblAuditLog")
data class AuditLog(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val tabel: String,
    val keterangan: String
)
