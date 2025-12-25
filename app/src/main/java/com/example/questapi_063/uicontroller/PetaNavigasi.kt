package com.example.questapi_063.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.questapi_063.View.DetailSiswaScreen
import com.example.questapi_063.View.EditSiswaScreen
import com.example.questapi_063.View.EntrySiswaScreen
import com.example.questapi_063.View.HomeScreen
import com.example.questapi_063.uicontroller.route.DestinasiDetail
import com.example.questapi_063.uicontroller.route.DestinasiEdit
import com.example.questapi_063.uicontroller.route.DestinasiEntry
import com.example.questapi_063.uicontroller.route.DestinasiHome

@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier // Menggunakan modifier dari parameter
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                // PERBAIKAN: Nama parameter harus 'navigateToItemUpdate' sesuai definisi di HomeScreen
                navigateToItemUpdate = { navController.navigate("${DestinasiDetail.route}/$it") }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = {
                    navController.navigate(DestinasiHome.route) {
                        popUpTo(DestinasiHome.route) { inclusive = true }
                    }
                }
            )
        }
        composable(
            DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { navController.navigate("${DestinasiEdit.route}/$it") },
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(
            DestinasiEdit.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEdit.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EditSiswaScreen(
                navigateBack = {
                    navController.popBackStack(DestinasiHome.route, false)
                },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}