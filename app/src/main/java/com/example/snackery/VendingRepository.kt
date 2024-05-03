package com.example.snackery

object VendingRepository {
    val vendingMachineList = listOf(
        VendingMachine(
            id = 0,
            campusArea = "North",
            location = "Location 1",
            imageResourceId = R.drawable.vend_img,
            isOpen = true,
            type = "Snacks",
            products = listOf(
                Product(name = "Chips", type = "Snacks", price = 1.5),
                Product(name = "Chocolate Bar", type = "Snacks", price = 1.0),
                Product(name = "Soda", type = "Beverage", price = 2.0)
            )
        ),
        VendingMachine(
            id = 1,
            campusArea = "Central",
            location = "Location 2",
            imageResourceId = R.drawable.vend_img,
            isOpen = false,
            type = "Drinks",
            products = listOf(
                Product(name = "Water Bottle", type = "Beverage", price = 1.0),
                Product(name = "Energy Drink", type = "Beverage", price = 2.5),
                Product(name = "Juice Box", type = "Beverage", price = 1.5)
            )
        ),
        VendingMachine(
            id = 2,
            campusArea = "West",
            location = "Location 3",
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
            location = "Location 4",
            imageResourceId = R.drawable.vend_img,
            isOpen = false,
            type = "Drinks",
            products = listOf(
                Product(name = "Soft Drink", type = "Beverage", price = 3.50),
                Product(name = "Iced Tea", type = "Beverage", price = 4.20),
                Product(name = "Sports Drink", type = "Beverage", price = 32.0)
            )
        )
    )
}