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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    var currentImage by remember {
        mutableStateOf(1)
    }
    fun increment(){
        if(currentImage<4)
            currentImage++
        else
            currentImage=4
    }
    fun decrement(){
        if(currentImage>1)
            currentImage--
        else
            currentImage=1
    }
    val imageResource=when(currentImage){
        1->R.drawable.superhero_1
        2->R.drawable.superhero_2
        3->R.drawable.superhero_3
        else->R.drawable.superhero_4
    }
    val (titleString, descriptionString) = when (currentImage) {
        1->R.string.title1 to R.string.description1
        2->R.string.title2 to R.string.description2
        3->R.string.title3 to R.string.description3
        else->R.string.title4 to R.string.description4
    }


    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            Modifier

                .weight(1f)
                .fillMaxWidth()
                .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Box(Modifier.shadow(5.dp)) {
                Image(
                    painter = painterResource( imageResource),
                    contentDescription = "Superhero image", contentScale = ContentScale.Crop,modifier= Modifier
                        .padding(30.dp)
                        .height(380.dp)
                        .width(280.dp)
                )
            }
        }
        Column(
            Modifier
                .width(400.dp)
                .padding(10.dp)
                .background(MaterialTheme.colorScheme.primaryContainer))
        {
            Text(text = stringResource(titleString), fontSize = 35.sp ,modifier=Modifier.padding(10.dp))

                Text(text = stringResource(descriptionString), fontWeight = FontWeight.Bold,modifier=Modifier.padding(10.dp))


        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp)
            , horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = { decrement() },modifier= Modifier
                .width(150.dp)
                .height(50.dp)) {
                Text(text = "Previous",fontSize = 20.sp)
            }
            Button(onClick = { increment() },modifier= Modifier
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