package com.hakan.rickandmortycompose.presentation.characters.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.hakan.rickandmortycompose.domain.model.Characters

@Composable
fun CharacterListRow(
    character: Characters,
    onItemClick: (Characters) -> Unit
) {

    Card(modifier = Modifier.fillMaxWidth()
        .padding(18.dp),
    backgroundColor = Color.LightGray,
    elevation = 10.dp) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick(character)
                }
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                rememberImagePainter(data = character.image),
                contentDescription = character.name,
                modifier = Modifier
                    .padding(16.dp)
                    .size(200.dp, 200.dp)
                    .clip(RectangleShape)
            )

            Column(
                modifier = Modifier.align(CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.h5,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = character.status,
                    style = MaterialTheme.typography.h5,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }

        }

    }
}








