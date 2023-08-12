package com.hakan.rickandmortycompose.presentation

sealed class Screen(val route: String){
    object CharacterScreen: Screen(route = "character_screen")
    object CharacterDetailScreen: Screen(route = "character_detail_screen")
}
