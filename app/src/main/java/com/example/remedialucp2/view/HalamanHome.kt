package com.example.remedialucp2.view

package com.example.remedialucp2.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.remedialucp2.view.route.DestinasiHome
import com.example.remedialucp2.viewmodel.BukuTampil
import com.example.remedialucp2.viewmodel.HomeViewModel
import com.example.remedialucp2.viewmodel.provider.PenyediaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanHome(
    navigateToEntryBuku: () -> Unit,
    navigateToDetailBuku: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PerpustakaanTopAppBar(
                title = DestinasiHome.titleRes,
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToEntryBuku,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah Buku"
                )
            }
        }
    ) { innerPadding ->
        val uiState by viewModel.homeUiState.collectAsState()

        BodyHomeBuku(
            listBuku = uiState.listBukuTampil,
            onBukuClick = navigateToDetailBuku,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}

@Composable
fun BodyHomeBuku(
    listBuku: List<BukuTampil>,
    onBukuClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (listBuku.isEmpty()) {
            Text(
                text = "Belum ada data buku",
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListBuku(
                listBuku = listBuku,
                onBukuClick = { onBukuClick(it.id) },
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }
    }
}

@Composable
fun ListBuku(
    listBuku: List<BukuTampil>,
    onBukuClick: (BukuTampil) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items = listBuku, key = { it.id }) { buku ->
            DataBuku(
                buku = buku,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onBukuClick(buku) }
            )
        }
    }
}

@Composable
fun DataBuku(
    buku: BukuTampil,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = buku.judul,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.weight(1f))
            }

            Text(
                text = "Kategori: ${buku.namaKategori}",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
