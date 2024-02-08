package com.example.assignmenttwoproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonWithLabel(context = this, buttonText = "Second Activity")
        }
    }
}


@Composable
fun ButtonWithLabel(context: Context, buttonText: String, modifier: Modifier = Modifier){
    Column (
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Chad Werning", fontSize = 32.sp, textAlign = TextAlign.Center)
        Text(text = "1370538", fontSize = 32.sp, textAlign = TextAlign.Center)
        Button(onClick = {
            val explicitIntent = Intent(context, SecondActivity::class.java)
            context.startActivity(explicitIntent)
        }) {
            Text(text = "$buttonText Explicitly")
        }
        Button(onClick = {
            val implicityIntent = Intent().apply {
                action = "com.example.assignmenttwoproject.ACTION_SHOW_SECOND_ACTIVITY"
                addCategory(Intent.CATEGORY_DEFAULT)
            }
            context.startActivity(implicityIntent)
        }) {
            Text(text = "$buttonText Implicitly")
        }
    }
}

//@Composable
//fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
//    var result by remember { mutableStateOf(1)}
//    Column (
//        modifier = modifier,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        val imageResource = when (result) {
//            1 -> R.drawable.dice_1
//            2 -> R.drawable.dice_2
//            3 -> R.drawable.dice_3
//            4 -> R.drawable.dice_4
//            5 -> R.drawable.dice_5
//            else -> R.drawable.dice_6
//        }
//
//        Image(painter = painterResource(imageResource), contentDescription = "Dice 1")
//        Button(onClick = { result = (1..6).random() }) {
//            Text(stringResource(R.string.roll))
//        }
//        Text(text = "You rolled $result")
//    }
//}

//@Composable
//fun DiceWithButtonAndImage(
//    modifier = Modifier
//        .fillMaxSize()
//        .wrapContentSize(Alignment.Center)
//){
////    Column (
////        verticalArrangement = Arrangement.Center,
////        modifier = modifier
////    ) {
//
////        Text(
////            text = message,
////            fontSize = 80.sp,
////            lineHeight = 100.sp,
////            textAlign = TextAlign.Center
////        )
////
////        Text(text = from, fontSize = 36.sp, modifier = Modifier.align(alignment = Alignment.End))
////    }
//}

//@Preview(showBackground = true, showSystemUi = true, name = "My Preview")
//@Composable
//fun AssignmentTwoApp() {
//    ButtonWithLabel(context = this)
//}