package com.example.remedialucp2.room


import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AuditLogDao {

    @Query("SELECT * FROM tblAuditLog ORDER BY id DESC")
    fun getAllLog(): Flow<List<AuditLog>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(log: AuditLog)

    @Delete
    suspend fun delete(log: AuditLog)
}
