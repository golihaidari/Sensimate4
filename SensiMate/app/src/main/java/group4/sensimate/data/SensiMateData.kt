package group4.sensimate.data

import androidx.compose.runtime.Immutable
import group4.sensimate.R

@Immutable
data class Profile(
    val fullname : String,
    val username : String,
    val email : String,
    val password : String,
    val birthday : String,
    val gender : String,
    val postalcode : Int
)

@Immutable
data class Event(
    val id : Int,
    val imageId: Int,
    val title: String,
    val description: String,
    val startDate: String,
    val endDate: String
)

@Immutable
data class Survey(
    val id : Int,
    val questions: List<Question>
)

data class Question(
    val SurveyId: Int,
    val id: Int,
    val type: String,
    val description: String,
    val option: List<String>
)

class EventSource(){
    fun loadEvents(): List<Event>{
        return listOf<Event>(
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),
            Event(1, R.drawable.ic_launcher_background, "wine", "lets celebrate", "1-1-22", "2-1-22"),

            )
    }
}

class SurveySource(){
    fun loadSurveyData(): Survey {
        val q1 = Question(1,1,"list","like it?", option= listOf<String>("1","2","3"))
        val q2 = Question(1,2,"line","work it?", option= listOf<String>("1","2","3"))
        val questionList= listOf<Question>(q1, q2)
        return Survey(1, questionList)
    }
}
