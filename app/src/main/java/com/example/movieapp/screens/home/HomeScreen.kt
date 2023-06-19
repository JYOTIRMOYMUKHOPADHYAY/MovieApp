package com.example.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.MovieRow
import com.example.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Movies",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.Magenta)
            )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            MainContent(navController = navController)
        }

    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Harry Potter",
        "Life",
        "Avatar 1",
        "300 2",
        "Harry Potter 3",
        "Life 4",
        "Avatar 5",
        "300 6",
        "Harry Potter 7",
        "Life 8"
    )
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {

            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                    Log.d("TAG", "MainContent: $movie")
                }
            }
        }
    }
}
