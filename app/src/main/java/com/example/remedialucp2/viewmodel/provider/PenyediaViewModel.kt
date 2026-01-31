package com.example.remedialucp2.viewmodel.provider

import com.example.remedialucp2.viewmodel.HomeViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.remedialucp2.repositori.AplikasiPerpustakaan


object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiUniversitas().container.repositoriBuku)
        }
        initializer {
            EntryViewModel(aplikasiUniversitas().container.repositoriBuku)
        }
        initializer {
                DetailViewModel(this.createSavedStateHandle(), aplikasiUniversitas().container.repositoriBuku)
        }
        initializer {
            EditViewModel(this.createSavedStateHandle(), aplikasiUniversitas().container.repositoriBuku)
        }
    }
}

/**
 * Fungsi ekstensi query untuk objek Application dan mengembalikan sebuah instance dari
 * AplikasiSiswa
 */

fun CreationExtras.aplikasiUniversitas(): AplikasiPerpustakaan =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiPerpustakaan)