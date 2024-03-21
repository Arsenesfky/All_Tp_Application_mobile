package com.example.sallelocation.Tp3

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import coil.compose.rememberImagePainter
import com.example.sallelocation.R
import com.example.sallelocation.Tp3.ui.theme.SalleLocationTheme
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class SecondeActivity<Painter> : ComponentActivity() {
    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService

    private var shouldShowCamera: MutableState<Boolean> = mutableStateOf(false)

    private lateinit var photoUri: Uri
    private var shouldShowPhoto: MutableState<Boolean> = mutableStateOf(false)

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Log.i("kilo", "Permission granted")
            shouldShowCamera.value = true
        } else {
            Log.i("kilo", "Permission denied")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SalleLocationTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "DEUXIEME ACTIVITER",
                        fontSize = 20.sp,
                        style= TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                        Spacer(modifier = Modifier.height(10.dp))
                    if (shouldShowCamera.value) {
                        CameraView(
                            outputDirectory = outputDirectory,
                            executor = cameraExecutor,
                            onImageCaptured = ::handleImageCapture,
                            onError = { Log.e("kilo", "View error:", it) }
                        )
                    }

                    if (shouldShowPhoto.value) {
                        Image(
                            painter = rememberImagePainter(photoUri),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                }/*
                if (shouldShowCamera.value) {
                    CameraView(
                        outputDirectory = outputDirectory,
                        executor = cameraExecutor,
                        onImageCaptured = ::handleImageCapture,
                        onError = { Log.e("kilo", "View error:", it) }
                    )
                }

                if (shouldShowPhoto.value) {
                    Image(
                        painter = rememberImagePainter(photoUri),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }*/
            }
        }
        requestCameraPermission()

        outputDirectory = getOutputDirectory()
        cameraExecutor = Executors.newSingleThreadExecutor()
    }



    private fun requestCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                Log.i("kilo", "Permission previously granted")
                shouldShowCamera.value = true
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CAMERA
            ) -> Log.i("kilo", "Show camera permissions dialog")

            else -> requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }
    private fun handleImageCapture(uri: Uri) {
        Log.i("kilo", "Image captured: $uri")
        shouldShowCamera.value = false

        photoUri = uri
        shouldShowPhoto.value = true
    }
    private fun getOutputDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }

        return if (mediaDir != null && mediaDir.exists()) mediaDir else filesDir
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }
}


