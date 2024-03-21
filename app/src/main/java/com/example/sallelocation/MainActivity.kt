package com.example.sallelocation

import DrawingScreen
import Line
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnLongClickListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TabPosition
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.sallelocation.Tp3.SecondeActivity
import com.example.sallelocation.ui.theme.SalleLocationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val lines = remember {
                mutableStateListOf<Line>()
            }
            SalleLocationTheme {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box (
                    ){
                        Text(text = "DELTA",style = TextStyle(
                            fontSize = 35.sp,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold
                        )
                        )
                    }
                    Box(
                        Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = {
                            val navigate = Intent(this@MainActivity,SecondeActivity::class.java)
                            startActivities(arrayOf(navigate))
                        }, modifier = Modifier.height(40.dp)
                        ) {
                            Text(text = "ouvrir une nouvelle activiter",style = TextStyle(
                                fontSize = 15.sp,
                                //fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.Bold
                            ))
                        }

                    }
                }



                // A surface container using the 'background' color from the theme


        }
    }
}


@Composable
fun TextfieldTest(){
    TextfieldTest()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SalleLocationTheme {

    }
}}

