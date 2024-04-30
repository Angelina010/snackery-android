package com.example.snackery

import androidx.compose.foundation.background
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
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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

        // Search Bar
        var searchText by remember { mutableStateOf("") }

        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text(text = "Search...") },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                cursorColor = Color.Black,
                textColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

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
