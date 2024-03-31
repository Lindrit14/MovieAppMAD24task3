package com.example.movieappmad24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
<<<<<<< HEAD
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme
=======
import com.example.movieappmad24.navigation.Navigation
>>>>>>> 251e74e8661457032c237dc80257d312cbe50782

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
<<<<<<< HEAD
            MovieAppMAD24Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card {
                        Image(painter = painterResource(id = R.drawable.movie_image), contentDescription = "placeholder_image")
                    }
                }
            }
        }
    }
}
=======
            Navigation()
        }
    }
}

>>>>>>> 251e74e8661457032c237dc80257d312cbe50782
