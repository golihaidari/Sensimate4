package group4.sensimate.data.repository

import group4.sensimate.R
import group4.sensimate.data.model.Event
import group4.sensimate.data.model.PossibleAnswer
import group4.sensimate.data.model.Question
import group4.sensimate.data.model.Survey


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
        val q1 = Question(1,1,"like it?", answer= PossibleAnswer.SingleChoice( listOf<String>( "","2","3")));
        val q2 = Question(1,2,"work it?", answer = PossibleAnswer.MultipleChoice( listOf<String>( "Yes", "No","so so")));
        val q3 = Question(1,3,"how do you feel about ux?", answer = PossibleAnswer.Slider(
            range = 1f..10f, steps = 3, startText = "strongly dislike",
            endText = "strongly like",
            neutralText = "neutral")
        );
        val questionList= listOf<Question>(q1,q2,q3)
        return Survey(1, questionList)
    }
}




