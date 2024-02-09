package com.example.myapplication5

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBio = findViewById<Button>(R.id.buttonProfile)
        btnBio.setOnClickListener {
            val intent = Intent(applicationContext, second_screen::class.java)
            startActivity(intent)
        }

        val btnProfile = findViewById<Button>(R.id.buttonLink)
        btnProfile.setOnClickListener {
            val newLink = Intent(Intent.ACTION_VIEW)
            newLink.data = Uri.parse("https://github.com/asmiliano/Android-Studio-Labs")
            startActivity(newLink)
        }

        val btnCamera = findViewById<Button>(R.id.buttonCamera)
        btnCamera.setOnClickListener {
            val openCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(openCamera, REQUEST_IMAGE_CAPTURE)
        }
    }

    companion object {
        const val REQUEST_IMAGE_CAPTURE = 1
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            // Обработка полученного изображения от камеры
        }
    }
}
