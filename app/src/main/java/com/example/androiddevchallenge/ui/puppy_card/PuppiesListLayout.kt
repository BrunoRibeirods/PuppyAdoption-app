package com.example.androiddevchallenge.ui.puppy_card

import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.entities.Puppy
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.AndroidDevChallengeTheme
import com.example.androiddevchallenge.ui.theme.BgBlue

@ExperimentalAnimationApi
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PuppiesListLayout(navController: NavController) {
    val viewModel = viewModel<PuppiesListViewModel>()

    val listState = rememberLazyListState()
    val showText = listState.firstVisibleItemScrollOffset == 0

    Scaffold() {

            AnimatedVisibility(visible = showText,initiallyVisible = true) {
                Header()

            }



            LazyColumn(state = listState) {

                items(viewModel.repository.getAllPuppies()) { puppy ->
                    Spacer(modifier = Modifier.height(26.dp))
                    PuppyCard(puppy = puppy)
                }
            }

    }


    


}

@Composable
fun Header(){

    Text(text = "Make a New Friend",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 26.sp,
            fontWeight = Bold,
            color = Color.White,
            textAlign = TextAlign.Center)

}


@Composable
fun PuppyCard(puppy: Puppy){
    Surface(color = Color.White, modifier = Modifier
        .padding(top = 18.dp, end = 16.dp, start = 16.dp, bottom = 5.dp)
        .clip(RoundedCornerShape(16.dp))) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .wrapContentHeight()
        ) {
            val image: Painter = painterResource(id = puppy.img)
            val imageModifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
            Image(
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = imageModifier
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = puppy.name, fontSize = 23.sp, fontWeight = Bold)
            Text(text = puppy.gender, fontSize = 16.sp)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewPuppy() {
    AndroidDevChallengeTheme {
        PuppyCard(puppy = Puppy("Marley", "Male", 10, R.drawable.dog))
    }
}