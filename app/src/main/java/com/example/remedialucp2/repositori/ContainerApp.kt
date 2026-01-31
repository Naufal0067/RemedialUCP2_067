package com.example.remedialucp2.repositori

import android.app.Application
import android.content.Context
import com.example.ucp2new.room.DatabasePerpustakaan


interface ContainerApp {
    val repositoriBuku: RepositoriBuku
    val repositoriKategori: RepositoriKategori
    val repositoriAudit: RepositoriAudit
}


class ContainerDataApp(private val context: Context) : ContainerApp {

    private val database by lazy { DatabasePerpustakaan.getDatabase(context) }

    override val repositoriBuku: RepositoriBuku by lazy {
        OfflineRepositoriBuku(
            bookItemDao = database.bookItemDao(),
            bookAuthorDao = database.bookAuthorDao(),
            auditLogDao = database.auditLogDao()
        )
    }

    override val repositoriKategori: RepositoriKategori by lazy {
        OfflineRepositoriKategori(
            categoryDao = database.categoryDao(),
            bookItemDao = database.bookItemDao(),
            auditLogDao = database.auditLogDao()
        )
    }

    override val repositoriAudit: RepositoriAudit by lazy {
        OfflineRepositoriAudit(
            auditLogDao = database.auditLogDao()
        )
    }
}


class AplikasiPerpustakaan : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}
