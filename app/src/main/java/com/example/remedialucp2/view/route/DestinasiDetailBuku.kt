package com.example.remedialucp2.view.route

import com.example.remedialucp2.R

object DestinasiDetailBuku : DestinasiNavigasi {
    override val route = "detail_matakuliah"
    override val titleRes = R.string.detail_buku
    const val itemIdArg = "idMataKuliah"
    val routeWithArgs = "$route/{$itemIdArg}"
}