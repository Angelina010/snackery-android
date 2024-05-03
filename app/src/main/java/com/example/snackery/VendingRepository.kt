package com.example.snackery

object VendingRepository {
    val vendingMachineList = listOf(

        VendingMachine(
            id = 0,
            campusArea = "North",
            location = "Gates 1",
            imageResourceId = R.drawable.vend_img,
            isOpen = true,
            type = "Snacks",
            products = listOf(
                Product(name = "Chips", type = "Snacks", price = 3.30),
                Product(name = "Chocolate Bar", type = "Snacks", price = 4.20),
                Product(name = "Soda", type = "Beverage", price = 3.50)
            )
        ),
        VendingMachine(
            id = 1,
            campusArea = "Central",
            location = "PSB 1",
            imageResourceId = R.drawable.vend_img,
            isOpen = false,
            type = "Drinks",
            products = listOf(
                Product(name = "Water Bottle", type = "Beverage", price = 3.00),
                Product(name = "Energy Drink", type = "Beverage", price = 4.00),
                Product(name = "Juice Box", type = "Beverage", price = 3.00)
            )
        ),
        VendingMachine(
            id = 2,
            campusArea = "West",
            location = "Rose House",
            imageResourceId = R.drawable.vend_img,
            isOpen = true,
            type = "Snacks",
            products = listOf(
                Product(name = "Granola Bar", type = "Snacks", price = 3.00),
                Product(name = "Trail Mix", type = "Snacks", price = 3.00),
                Product(name = "Candy", type = "Snacks", price = 4.00)
            )
        ),
        VendingMachine(
            id = 3,
            campusArea = "South",
            location = "JAM 2",
            imageResourceId = R.drawable.vend_img,
            isOpen = false,
            type = "Drinks",
            products = listOf(
                Product(name = "Soft Drink", type = "Beverage", price = 3.50),
                Product(name = "Iced Tea", type = "Beverage", price = 4.20),
                Product(name = "Sports Drink", type = "Beverage", price = 3.20)
            )
        )

    )
}