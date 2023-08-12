package com.hakan.rickandmortycompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hakan.rickandmortycompose.presentation.Screen
import com.hakan.rickandmortycompose.presentation.character_detail.views.CharacterDetailScreen
import com.hakan.rickandmortycompose.presentation.characters.views.CharacterScreen
import com.hakan.rickandmortycompose.presentation.theme.RickAndMortyComposeTheme
import com.hakan.rickandmortycompose.util.Constants.character_id
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.CharacterScreen.route){

                        composable(route = Screen.CharacterScreen.route){
                            CharacterScreen(navController = navController)
                        }

                       composable(route = Screen.CharacterDetailScreen.route+"/{${character_id}}"){
                            CharacterDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
