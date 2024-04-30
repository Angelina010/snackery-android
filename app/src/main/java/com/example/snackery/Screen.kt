package com.example.snackery


sealed class Screen(
    val route: String
) {
    object Home : Screen(
        route = "home"
    )
}