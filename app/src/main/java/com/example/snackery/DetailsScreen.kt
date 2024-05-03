package com.example.snackery

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun DetailsScreen(navController: NavController, vendId: String?) {
    val sheetState =
        androidx.compose.material.rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetContent = { Payment(onClick = { scope.launch { sheetState.hide() } }) },
        sheetState = sheetState
    ) {
        if (vendId != null) {
            val vendId = vendId.toInt()
            val vendingMachine = VendingRepository.vendingMachineList.getOrNull(vendId)
            if (vendingMachine != null) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = vendingMachine.location)
                            },
                            navigationIcon = {
                                IconButton(onClick = { navController.navigateUp() }) {
                                    Icon(
                                        Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = "Back"
                                    )
                                }
                            }
                        )
                    }
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = vendingMachine.imageResourceId),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )

                                Button(
                                    modifier = Modifier.align(Alignment.BottomEnd),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFDC6601)
                                    ),
                                    onClick = {
                                        scope.launch {
                                            sheetState.show()
                                        }
                                    }
                                ) {
                                    Text(text = "Payment Methods")
                                }
                            }
                        }
                        item {
                            // Display vending machine details
                            Text(
                                text = "Machine Type: ${vendingMachine.type}",
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                            // Display vending machine status
                            Text(
                                text = "Status: ${if (vendingMachine.isOpen) "Open" else "Closed"}",
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                            )

                            // Display product list with prices
                            Text(
                                text = "Products:",
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                            vendingMachine.products.forEach { product ->
                                Text(
                                    text = "${product.name}: $${product.price}",
                                    modifier = Modifier.padding(start = 32.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}