package com.example.aisuperheroarts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aisuperheroarts.ui.theme.AISuperheroArtsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AISuperheroArtsTheme {
                AISuperheroArtApp()
            }
        }
    }
}

@Composable
fun ArtsContainer( modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            Modifier

                .weight(1f)
                .fillMaxWidth()
                .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Box(Modifier.shadow(5.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Blah", contentScale = ContentScale.Crop,modifier= Modifier
                        .padding(30.dp)
                        .height(300.dp)
                        .width(240.dp)
                )
            }
        }
        Column(
            Modifier
                .width(400.dp)
                .padding(10.dp)
                .background(MaterialTheme.colorScheme.primaryContainer))
        {
            Text(text = "Art 1", fontSize = 35.sp ,modifier=Modifier.padding(10.dp))
            Row (Modifier.padding(10.dp)){
                Text(text = "description", fontWeight = FontWeight.Bold)
                Text(text = "(2021) ")
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp)
            , horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = { /*TODO*/ },modifier= Modifier
                .width(150.dp)
                .height(50.dp)) {
                Text(text = "Previous",fontSize = 20.sp)
            }
            Button(onClick = { /*TODO*/ },modifier= Modifier
                .width(150.dp)
                .height(50.dp)) {
                Text(text = "Next",fontSize = 20.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AISuperheroArtApp() {
    AISuperheroArtsTheme {
        ArtsContainer()
    }
}