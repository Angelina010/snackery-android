package com.example.snackery

data class VendingMachine(
    val id: Int,
    val campusArea: String,
    val location: String,
    val imageResourceId: Int,
    val isOpen: Boolean,
    val type: String,
    val products: List<Product>
)
