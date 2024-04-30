package com.example.snackery

object VendingRepository {
    val vendingMachineList = listOf(
        VendingMachine(1, "North", "Location 1", R.drawable.vend_img, true),
        VendingMachine(2, "Central", "Location 2", R.drawable.vend_img, false),
        VendingMachine(3, "West", "Location 3", R.drawable.vend_img, true),
        VendingMachine(4, "South", "Location 4", R.drawable.vend_img, false)
    )
}