package com.example.movieappmad24.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieappmad24.R
import com.example.movieappmad24.models.getMovies



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, movieId: String?) {
    val movie = getMovies().find { it.id == movieId }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (movie != null) {
                        Text(movie.title)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            if (movie != null) {
                MovieRow(movie = movie)
            } // Reuse your MovieRow composable
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(
                Modifier
                    .height(300.dp)
            ) {
                if (movie != null) {
                    this.items(items = movie.images) { image ->
                        MoviePicture(resourceLink = image, title = movie.title)
                    }
                }
                }
            }
        }
    }



@Composable
fun MoviePicture(resourceLink: String, title: String) {
    Card(
        shape = RoundedCornerShape(size = 20.dp),
        modifier = Modifier
            .padding(all = 15.dp)
    ) {
        AsyncImage(
            model = resourceLink,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.movie_image),
            contentDescription = "$title Image",
            modifier = Modifier
                .aspectRatio(ratio = 1f)
        )
    }
}

