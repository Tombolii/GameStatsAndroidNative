package de.tomboli.app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class GamesGroup(
    val gamesGroupId: String,
    val name: String,
    val member: List<User>,
    val games: List<GameInfo>
) : Parcelable