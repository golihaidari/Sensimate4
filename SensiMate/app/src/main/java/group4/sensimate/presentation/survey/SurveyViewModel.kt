package group4.sensimate.presentation.survey

import androidx.lifecycle.*
import group4.sensimate.data.repository.SurveyData
import group4.sensimate.data.repository.SurveyRepository
import kotlinx.coroutines.launch


class SurveyViewModel (
    private val surveyRepository: SurveyRepository,
): ViewModel()
{
    private val _uiState = MutableLiveData<SurveyState>()
    val uiState: LiveData<SurveyState> get() = _uiState
    private lateinit var surveyInitialState: SurveyState

    init {
        viewModelScope.launch {
            val survey = surveyRepository.getSurvey()

            val questions:List<QuestionState> = survey.questions.mapIndexed { index, question ->
                val showPrevious = index > 0
                val showDone = index == survey.questions.size - 1
                QuestionState(
                    question = question,
                    questionIndex = index,
                    totalQuestionsCount = survey.questions.size,
                    showPrevious = showPrevious,
                    showDone = showDone
                )
            }

            surveyInitialState = SurveyState.Questions(survey.id, questions)
            _uiState.value = surveyInitialState
        }
    }


    fun computeResult(surveyQuestions: SurveyState.Questions) {
        val answers = surveyQuestions.questionsState.mapNotNull { it.answer }
        val result = surveyRepository.getSurveyResult(answers)
        _uiState.value = SurveyState.Result(surveyQuestions.surveyId, result)
    }

    private fun getLatestQuestionId(): Int? {
        val latestState = _uiState.value
        if (latestState != null && latestState is SurveyState.Questions) {
            return latestState.questionsState[latestState.currentQuestionIndex].question.id
        }
        return null
    }
}



class SurveyViewModelFactory(
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SurveyViewModel::class.java)) {
            return SurveyViewModel(SurveyData) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}