package com.example.snackery

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun DetailsScreen(navController: NavController, vendId: String?) {
    if (vendId != null) {
        val vendId = vendId.toInt()
        val vendMac = VendingRepository.vendingMachineList[vendId]
        Text(vendMac.location)
    }
}