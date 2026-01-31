package com.example.remedialucp2.view.route

import com.example.remedialucp2.R

object DestinasiEditBuku : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_buku
    const val itemIdArg = "idMataKuliah"
    val routeWithArgs = "$route/{$itemIdArg}"
}