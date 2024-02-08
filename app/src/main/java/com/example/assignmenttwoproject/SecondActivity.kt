package com.example.assignmenttwoproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Mobile Software Engineering Challenges", fontSize = 20.sp, modifier =  Modifier.align(Alignment.CenterHorizontally))

                Spacer(modifier = Modifier.height(16.dp))

                Box(contentAlignment = Alignment.TopStart){
                    Column (horizontalAlignment = Alignment.Start){
                        Text(text = "1. Device Fragmentation")
                        Text(text = "2. OS Fragmentation")
                        Text(text = "3. Device and OS Fragmentation")
                        Text(text = "4. Unstable and Dynamic Environment")
                        Text(text = "5. Rapid Changes")
                        Text(text = "6. Tool Support")
                        Text(text = "7. Low Tolerance By Users")
                        Text(text = "8. Low Security and Privacy Awareness")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { finish() }, modifier = Modifier.align(Alignment.CenterHorizontally) ){
                    Text(text = "Go back to main")
                }
            }
        }
    }
}