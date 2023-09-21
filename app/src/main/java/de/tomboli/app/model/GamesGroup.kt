package de.tomboli.app.model

data class GamesGroup(
    val gamesGroupId: String,
    val name: String,
    val member: User,
    val games: GameInfo
)