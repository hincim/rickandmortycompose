package com.hakan.rickandmortycompose.presentation.characters.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hakan.rickandmortycompose.presentation.Screen
import com.hakan.rickandmortycompose.presentation.characters.CharactersViewModel

@Composable
fun CharacterScreen(
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {

        Column() {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.characters) { character ->
                    CharacterListRow(character = character, onItemClick = {
                        navController.navigate(Screen.CharacterDetailScreen.route+"/${character.id}")
                    })
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}






