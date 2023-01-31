package de.tomboli.app.modle

data class GamesGroup(
    val gamesGroupId: String,
    val name: String,
    val member: User,
    val games: GameInfo
)