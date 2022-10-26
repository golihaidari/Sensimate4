package group4.sensimate

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

interface SensiMateDestination {
    val title: String
    val route: String
    val icon: ImageVector
}


object Events : SensiMateDestination {
    override val title= "Events"
    override val route = "events"
    override val icon = Icons.Default.DateRange
}

object Search : SensiMateDestination {
    override val title= "Search"
    override val route = "Search"
    override val icon = Icons.Default.Search
}

object Profile : SensiMateDestination {
    override val title= "Profile"
    override val route = "profile"
    override val icon = Icons.Default.Person
}



