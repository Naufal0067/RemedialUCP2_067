package com.example.remedialucp2.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.remedialucp2.view.HalamanHome
import com.example.remedialucp2.view.route.DestinasiDetailBuku
import com.example.remedialucp2.view.route.DestinasiDetailBuku.itemIdArg
import com.example.remedialucp2.view.route.DestinasiEditBuku
import com.example.remedialucp2.view.route.DestinasiEntryBuku
import com.example.remedialucp2.view.route.DestinasiHome

@Composable
fun SiswaApp(navController: NavHostController= rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController=navController, startDestination = DestinasiHome.route, modifier = Modifier)
    {
        composable(DestinasiHome.route){
            HalamanHome(
                navigateToItemEntry = {navController.navigate(DestinasiEntryBuku.route)},

                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetailBuku.route}/${it}")
                }
            )
        }
        composable(DestinasiEntryBuku.route){
            EntryBukuScreen(navigateBack = { navController.popBackStack()})
        }

        composable(route = DestinasiDetailBuku.routeWithArgs,
            arguments = listOf(navArgument(itemIdArg) {
                type = NavType.IntType
            })
        ){
            DetailSiswaScreen(
                navigateToEditItem = {navController.navigate("${DestinasiEditBuku.route}/$it")},
                navigateBack = {navController.navigateUp()})
        }
        composable(
            route = DestinasiEditBuku.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEditBuku.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }

    }
}