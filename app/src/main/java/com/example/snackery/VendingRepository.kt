package com.example.snackery

object VendingRepository {
    val vendingMachineList = listOf(
        VendingMachine(0, "North", "Location 1", R.drawable.vend_img, true),
        VendingMachine(1, "Central", "Location 2", R.drawable.vend_img, false),
        VendingMachine(2, "West", "Location 3", R.drawable.vend_img, true),
        VendingMachine(3, "South", "Location 4", R.drawable.vend_img, false)
    )
}