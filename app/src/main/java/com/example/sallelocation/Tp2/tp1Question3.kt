package com.example.sallelocation.Tp2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
public fun AutreEvenement(){
    Box(modifier = Modifier
        .width(250.dp)
        .height(350.dp)
    ){
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter){
        Box(modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .verticalScroll(rememberScrollState()),
        ) {
            Text(text = "groupe delta 5 personne",
                fontSize = 40.sp
            )

        }
    }
}
