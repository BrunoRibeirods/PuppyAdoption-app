package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.puppy_card.PuppiesListLayout
import com.example.androiddevchallenge.ui.theme.AndroidDevChallengeTheme
import com.example.androiddevchallenge.ui.theme.BgBlue

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidDevChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = BgBlue) {

                    HomePuppies()

                }
            }
        }
    }
}

@Composable
fun HomePuppies(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = "puppies") {
        composable("puppies") {
            PuppiesListLayout(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidDevChallengeTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = BgBlue) {

            HomePuppies()

        }
    }
}