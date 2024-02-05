package de.tomboli.app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameInfo(
    val name: String,
) : Parcelable