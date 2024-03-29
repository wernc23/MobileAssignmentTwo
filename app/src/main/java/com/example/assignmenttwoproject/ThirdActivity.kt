package com.example.assignmenttwoproject

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ThirdActivity : ComponentActivity() {
    private lateinit var cameraOpenId: Button
    private lateinit var clickImageId: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                setContentView(R.layout.activity_main)

                // By ID we can get each component which id is assigned in XML file get Buttons and imageview.
                cameraOpenId = findViewById(R.id.camera_button)
                clickImageId = findViewById(R.id.click_image)

                // Camera_open button is for open the camera and add the setOnClickListener in this button
                cameraOpenId.setOnClickListener(View.OnClickListener { v: View? ->
                    // Create the camera_intent ACTION_IMAGE_CAPTURE it will open the camera for capture the image
                    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    // Start the activity with camera_intent, and request pic id
                    startActivityForResult(cameraIntent, pic_id)
                })
            }

            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button(
                    onClick = { finish() },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Go back to main")
                }
            }
        }
    }

    // This method will help to retrieve the image
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Match the request 'pic id with requestCode
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            val photo = data!!.extras!!["data"] as Bitmap?
            // Set the image in imageview for display
            clickImageId.setImageBitmap(photo)
        }
    }

    companion object {
        // Define the pic id
        private const val pic_id = 123
    }
}