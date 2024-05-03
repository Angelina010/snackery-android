package com.example.snackery

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun VendingMachineCard(vendingMachine: VendingMachine, onClick: ()-> Unit) {
    Card(
        modifier = Modifier
            //.fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Box(
        ) {
            Image(
                painter = painterResource(id = vendingMachine.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .width(220.dp)
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            val gradient = Brush.verticalGradient(
                colors = listOf(Color.Transparent, Color.Black),
            )
            Box(modifier = Modifier.width(220.dp).height(120.dp).background(gradient)){

            }
            Text(modifier = Modifier.align(Alignment.BottomStart).padding(start = 8.dp, bottom = 8.dp),
                text = vendingMachine.location,
                style = MaterialTheme.typography.body1,
                color = Color.White,
            )
        }
    }
}

