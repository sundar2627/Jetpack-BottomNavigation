package com.example.jetpacknavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpacknavigation.ui.theme.JetpackNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackNavigationTheme {
               mainBottomBar()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun mainBottomBar() {

    var selectedItem by remember { mutableStateOf(0) }

   Scaffold(bottomBar = {
       myBottomBar() {
           selectedItem = it
       }

   }) {  o->
       when (selectedItem){
           0 ->TabOne()
           1 -> TabTwo()
           2 -> TabThree()
       }

   }
}

@Composable
fun labelText(label:String){
    Text(text = label)

}
@Composable
fun myBottomBar(onselected:(Int)->Unit) {
BottomNavigation {
    BottomNavigationItem(selected = true, onClick = {onselected(0)},
        icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "") },
       // icon = {Icons.Filled.Home}
        label ={ labelText(label = "Home")})
    BottomNavigationItem(selected = true, onClick = {onselected(1)}, icon = {Icons.Filled.Settings}, label ={ labelText(label = "Settings")})

    BottomNavigationItem(selected = true, onClick = {onselected(2)},
        icon = {Icon(imageVector = Icons.Filled.Call, contentDescription = "")}, label ={ labelText(label = "Call")})
}
}


@Composable
fun TabOne() {

    Column (Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Text("Tab One", style = TextStyle(fontSize = 24.sp, color = Color.Blue, textAlign = TextAlign.Center))

    }
  }

@Composable
fun TabTwo() {

    Column (Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Text("Tab Two", style = TextStyle(fontSize = 24.sp, color = Color.Blue, textAlign = TextAlign.Center))
    }
   }

@Composable
fun TabThree() {
    Column (Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Text("Tab Three", style = TextStyle(fontSize = 24.sp, color = Color.Blue, textAlign = TextAlign.Center))
    }
}