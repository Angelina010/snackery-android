package com.example.snackery

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController


@Composable
fun MainScreen(navController: NavHostController) {
//    val vendId = 3
//    val vendingMachine = VendingRepository.vendingMachineList.find { vendingMachine -> vendingMachine.id == vendId }

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        // Banner with heading "Snackery"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(color = Color(0xFFDC6601)) // Banner color
        ) {
            // Heading "Snackery" at the bottom left
            Text(
                text = "Snackery",
                style = MaterialTheme.typography.h3.copy(fontWeight = FontWeight.Bold), // Bold font
                color = Color.White,
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 16.dp) // Positioning the text
                    .align(Alignment.BottomStart) // Aligning to bottom left
            )
        }


        // To search page Search Bar
        Row(
            modifier = Modifier
                .clickable(onClick = {
                    navController.navigate("search")
                })
                .padding(20.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .background(Color.LightGray.copy(alpha = 0.4f), shape = RoundedCornerShape(16.dp))
                .padding(horizontal = 24.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(
                text = "Search...",
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }

        // Lazy row for buttons
        LazyRow(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            val buttons = listOf("North", "Central", "West", "College Town")
            items(buttons) { button ->
                Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 4.dp)
                        .height(40.dp), // Ensure all buttons have the same height
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFFDC6601), // Same color as banner
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(32.dp)
                ) {
                    Text(text = button)
                }
            }
        }

        // Lazy rows for "Nearest to you" and "Open now"
        Column(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(
                text = "Nearest to you",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp, start = 16.dp)
            )
            LazyRow {
                item {
                    Spacer(modifier = Modifier.width(16.dp))
                }
                //change (VendingRepository.vendingMachineList) to function that takes in filters, returns updated list
                items(VendingRepository.vendingMachineList) { vendingMachine ->
                    VendingMachineCard(vendingMachine, onClick = {
                        navController.navigate("details/${vendingMachine.id}")
                    })
                    Spacer(modifier = Modifier.width(12.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Open now",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp, start = 16.dp)
            )
            LazyRow {
                item {
                    Spacer(modifier = Modifier.width(12.dp))
                }
                val openNowMachines =
                    VendingRepository.vendingMachineList.filter { vendingMachine ->
                        vendingMachine.isOpen
                    }
                items(openNowMachines) { vendingMachine ->
                    VendingMachineCard(vendingMachine, onClick = {
                        navController.navigate("details/${vendingMachine.id}")
                    })
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}
