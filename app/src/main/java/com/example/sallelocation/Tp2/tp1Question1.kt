package com.example.sallelocation.Tp2

import android.util.Log
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontStyle

@Composable
public fun Tp(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val (text, setText ) = remember {
            mutableStateOf("Texte initial")
        }
        Button(onClick = {
            setText("Button clicker")},
            modifier = Modifier.pointerInput(Unit){
                detectTapGestures(
                    onLongPress = { Log.d("onLongPress","okkkkk")}
                )
            }) {
            Text("click me")

        }
        Text(text, fontStyle = FontStyle.Italic)
    }
}

