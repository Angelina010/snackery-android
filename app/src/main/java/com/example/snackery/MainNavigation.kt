package com.example.snackery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavigation(navController: NavHostController){


    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(Screen.Home.route){

            MainScreen(navController)
        }


        composable("details/{vendId}"){
                backStackEntry ->
            DetailsScreen(navController, backStackEntry.arguments?.getString("vendId"))
        }

        composable("search"){
                backStackEntry ->
            SearchScreen(navController)
        }
    }
}

