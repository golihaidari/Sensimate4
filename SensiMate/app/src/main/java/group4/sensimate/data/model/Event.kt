package group4.sensimate.data.model

import androidx.compose.runtime.Immutable

@Immutable
data class Event(
    val id : Int,
    val imageId: Int,
    val title: String,
    val description: String,
    val startDate: String,
    val endDate: String
)