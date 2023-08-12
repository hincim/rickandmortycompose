package com.hakan.rickandmortycompose.presentation.characters.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hakan.rickandmortycompose.R
import com.hakan.rickandmortycompose.domain.model.Characters

@Composable
fun DrawerComponent(characters: List<Characters>) {
    Spacer(modifier = Modifier.height(16.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            contentDescription = "Rick And Morty",
            painter = painterResource(id = R.drawable.rickandmorty),
            modifier = Modifier
                .padding(16.dp)
                .size(200.dp, 200.dp)
                .clip(RectangleShape)
        )

        Text(text = "Episodes", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(characters) { character ->
                Text(text = character.name)
            }
        }
    }
}
