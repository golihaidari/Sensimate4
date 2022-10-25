package group4.sensimate

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

interface SensiMateDestination {
    val title: String
    val route: String
    val icon: ImageVector
}

object Welcome : SensiMateDestination {
    override val title= "welcome"
    override val route = "welcome"
    override val icon = Icons.Default.Home
}

object Profile : SensiMateDestination {
    override val title= "profile"
    override val route = "profile"
    override val icon = Icons.Default.Person
}

object Events : SensiMateDestination {
    override val title= "events"
    override val route = "events"
    override val icon = Icons.Default.DateRange
}



