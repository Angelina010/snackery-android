package com.example.snackery

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController




@OptIn(ExperimentalMaterial3Api::class)
@Composable
//, onSearch: (String) -> Unit
fun SearchScreen(navController: NavController) {
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(color = Color(0xFFDC6601)) // Banner color
            ) {
                // Heading "Snackery" at the bottom left
                androidx.compose.material.Text(
                    text = "Search",
                    style = androidx.compose.material.MaterialTheme.typography.h3.copy(fontWeight = FontWeight.Bold), // Bold font
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 16.dp) // Positioning the text
                        .align(Alignment.BottomStart) // Aligning to bottom left
                )
            }
        },
        content = {contentPadding ->
            Column() {
                var searchText by remember { mutableStateOf("") }

                TextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(contentPadding),
                    placeholder = { androidx.compose.material.Text(text = "Search...") },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        cursorColor = Color.Black,
                        textColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                val originalMap = VendingRepository.vendingMachineList
                val filteredMap = originalMap.filter {
                    it.location.contains(searchText) || it.campusArea.contains(searchText)
                }
                Spacer(modifier = Modifier.height(20.dp))
                LazyColumn(Modifier.align(Alignment.CenterHorizontally)) {
                    filteredMap.forEach {
                        item{VendingMachineCard(it, onClick = {
                            navController.navigate("details/${it.id}") }
                        )
                        Spacer(modifier = Modifier.height(20.dp))}
                    }
                }

                androidx.compose.material.Button(
                    onClick = { navController.navigate(Screen.Home.route) },
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 4.dp)
                        .height(40.dp).align(Alignment.CenterHorizontally), // Ensure all buttons have the same height
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFFDC6601), // Same color as banner
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(32.dp)
                ) {
                    androidx.compose.material.Text(text = "Home")
                }
            }
        }
    )
}
