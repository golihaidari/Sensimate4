package group4.sensimate.presentation.survey

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.*
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.siddroid.holi.brushes.GradientMixer
import group4.sensimate.R
import group4.sensimate.data.model.*
import group4.sensimate.data.repository.surveyQuestions
import group4.sensimate.ui.theme.SensiMateTheme
import java.io.FileOutputStream

class SurveyActivity : ComponentActivity() {
    val viewModel: SurveyViewModel by viewModels {
        SurveyViewModelFactory()
    }

    @SuppressLint("SdCardPath")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensiMateTheme {

                //LoadSurvey(survey = SurveySource().loadSurveyData())

                val state = viewModel.uiState.observeAsState().value?:return@SensiMateTheme
                when (state) {
                    is SurveyState.Questions -> SurveyScreen(
                        questions = state,
                        onDonePressed = { viewModel.computeResult(state) },
                        onBackPressed = {
                            this.onBackPressedDispatcher.onBackPressed()
                        }
                    )
                    is SurveyState.Result -> SurveyResultScreen(
                        result = state,
                        onDonePressed = {
                            this.onBackPressedDispatcher.onBackPressed()
                        }
                    )
                }
                FileOutputStream("/data/user/0/group4.sensimate/files/Surveys.csv").apply { writeCsv(surveyQuestions) }
            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun LoadSurveyPreview() {
    SensiMateTheme {
        //SurveyScreen()
    }
}

private const val CONTENT_ANIMATION_DURATION = 500
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SurveyScreen(
    questions: SurveyState.Questions,
    onDonePressed: () -> Unit,
    onBackPressed: () -> Unit
){
    val questionState = remember(questions.currentQuestionIndex) {
        questions.questionsState[questions.currentQuestionIndex]
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(R.color.pink_50))
    ){
        val brush= GradientMixer.topToBottom(colorResource(R.color.pink_300),colorResource(R.color.pink_100))
        Box( modifier = Modifier
            .size(400.dp)
            .clip(CircleShape)
            .align(alignment = Alignment.TopCenter)
            .background(brush = brush) )

        Box( modifier = Modifier
            .size(400.dp)
            .clip(CircleShape)
            .align(alignment = Alignment.Center)
            .background(colorResource(R.color.pink_200)) )

        Box( modifier = Modifier
            .size(400.dp)
            .clip(CircleShape)
            .align(alignment = Alignment.BottomCenter)
            .background(brush = brush) )

        Scaffold(
            backgroundColor = Color.Transparent,
            topBar = {
                SurveyTopBar(
                    questionIndex = questionState.questionIndex,
                    totalQuestionsCount = questionState.totalQuestionsCount,
                    onBackPressed = onBackPressed
                )
            },
            content = { innerPadding ->
                AnimatedContent(
                    targetState = questionState,
                    transitionSpec = {
                        val animationSpec: TweenSpec<IntOffset> = tween(CONTENT_ANIMATION_DURATION)
                        val direction =
                            if (targetState.questionIndex > initialState.questionIndex) {
                                // Going forwards in the survey: Set the initial offset to start
                                // at the size of the content so it slides in from right to left, and
                                // slides out from the left of the screen to -fullWidth
                                AnimatedContentScope.SlideDirection.Left
                            } else {
                                // Going back to the previous question in the set, we do the same
                                // transition as above, but with different offsets - the inverse of
                                // above, negative fullWidth to enter, and fullWidth to exit.
                                AnimatedContentScope.SlideDirection.Right
                            }
                        slideIntoContainer(
                            towards = direction,
                            animationSpec = animationSpec
                        ) with
                                slideOutOfContainer(
                                    towards = direction,
                                    animationSpec = animationSpec
                                )
                    }
                ) { targetState ->
                    QuestionContent(
                        question = targetState.question,
                        answer = targetState.answer,
                        onAnswer = {
                            if (it !is Answer.PermissionsDenied) {
                                targetState.answer = it
                            }
                            targetState.enableNext = true
                        },
                        modifier = Modifier
                            //.fillMaxSize()
                            .padding(innerPadding)
                            .background(Color.Transparent)
                    )
                }
            },
            bottomBar = {
                SurveyBottomBar(
                    questionState = questionState,
                    onPreviousPressed = { questions.currentQuestionIndex-- },
                    onNextPressed = { questions.currentQuestionIndex++ },
                    onDonePressed = onDonePressed
                )
            }
        )

    }
}


@Composable
fun SurveyResultScreen(
    result: SurveyState.Result,
    onDonePressed: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(R.color.pink_50))
    ) {
        val brush = GradientMixer.topToBottom(
            colorResource(R.color.pink_300),
            colorResource(R.color.pink_100)
        )
        Box( modifier = Modifier
            .size(400.dp)
            .clip(CircleShape)
            .align(alignment = Alignment.TopCenter)
            .background(brush = brush) )

        Box( modifier = Modifier
            .size(400.dp)
            .clip(CircleShape)
            .align(alignment = Alignment.Center)
            .background(colorResource(R.color.pink_200)) )

        Box( modifier = Modifier
                .size(400.dp)
                .clip(CircleShape)
                .align(alignment = Alignment.BottomCenter)
                .background(brush = brush) )

        Scaffold(
            backgroundColor = Color.Transparent,
            content = { innerPadding ->
                val modifier = Modifier.padding(innerPadding)
                SurveyResult(result = result, modifier = modifier)
            },
            bottomBar = {
                OutlinedButton(
                    shape= CircleShape,
                    onClick = { onDonePressed() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 24.dp)
                ) {
                    Text(text = stringResource(id = R.string.done))
                }
            }
        )
    }
}

@Composable
private fun SurveyResult(
    result: SurveyState.Result,
    modifier: Modifier = Modifier
)
{
    Box(
        modifier = Modifier.fillMaxSize()
        .padding(vertical = 8.dp),
    )
    {
        Box(
            modifier = Modifier
                .size(400.dp)
                //.clip(CircleShape)
                .align(alignment = Alignment.Center)
                .background(Color.White.copy(alpha= 0.15f))
        )
        {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                item {
                    Spacer(modifier = Modifier.height(44.dp))
                    Text(
                        text = result.surveyResult.library,
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    Text(
                        text = stringResource(
                            result.surveyResult.result,
                            result.surveyResult.library
                        ),
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(20.dp)
                    )
                    Text(
                        text = stringResource(
                            result.surveyResult.description,
                            result.surveyResult.library
                        ),
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun SurveyTopBar(
    questionIndex: Int,
    totalQuestionsCount: Int,
    onBackPressed: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier
                .padding(vertical = 20.dp)
                .align(Alignment.Center)
            ) {
                Text( text = (questionIndex + 1).toString() )
                Text( text = stringResource(R.string.question_count, totalQuestionsCount) )
            }

            IconButton(
                onClick = onBackPressed,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp)
            ) {
                Icon(
                    Icons.Filled.Close,
                    contentDescription = stringResource(id = R.string.close),
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }

        val animatedProgress by animateFloatAsState(
            targetValue = (questionIndex + 1) / totalQuestionsCount.toFloat(),
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            progress = animatedProgress,
            backgroundColor= Color.White,
            color = colorResource(id = R.color.violets_blue)
        )
    }
}

@Composable
private fun SurveyBottomBar(
    questionState: QuestionState,
    onPreviousPressed: () -> Unit,
    onNextPressed: () -> Unit,
    onDonePressed: () -> Unit
) {
    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        if (questionState.showPrevious) {
            OutlinedButton(
                onClick = onPreviousPressed,
                shape = CircleShape,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) {
                Text(text = stringResource(id = R.string.previous))
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
        if (questionState.showDone) {
            Button(
                onClick = onDonePressed,
                shape = CircleShape,
                enabled = questionState.enableNext,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) {
                Text(text = stringResource(id = R.string.done))
            }
        } else {
            Button(
                onClick = onNextPressed,
                shape = CircleShape,
                enabled = questionState.enableNext,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)

            ) {
                Text(text = stringResource(id = R.string.next))
            }
        }
    }
}



@Composable
private fun QuestionContent(
    question: Question,
    answer: Answer<*>?,
    onAnswer: (Answer<*>) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = question.id.toString() +". " + question.text,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp, horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            when(question.answer) {
                is PossibleAnswer.SingleChoice -> SingleChoiceQuestion(
                    possibleAnswer = question.answer,
                    answer = answer as Answer.SingleChoice?,
                    onAnswerSelected = { answer -> onAnswer(Answer.SingleChoice(answer)) },
                    modifier = Modifier.fillParentMaxWidth()
                )

                is PossibleAnswer.MultipleChoice -> MultipleChoiceQuestion(
                    possibleAnswer = question.answer,
                    answer = answer as Answer.MultipleChoice?,
                    onAnswerSelected = { newAnswer, selected ->
                        // create the answer if it doesn't exist or update it based on the user's selection
                        if (answer == null) {
                            onAnswer(Answer.MultipleChoice(setOf(newAnswer)))
                        } else {
                            onAnswer(answer.withAnswerSelected(newAnswer, selected))
                        }
                    },
                    modifier = Modifier.fillParentMaxWidth()
                )


                is PossibleAnswer.Slider -> SliderQuestion(
                    possibleAnswer = question.answer,
                    answer = answer as Answer.Slider?,
                    onAnswerSelected = { onAnswer(Answer.Slider(it)) },
                    modifier = Modifier.fillParentMaxWidth()
                )

            }
        }
    }
}

@Composable
private fun SingleChoiceQuestion(
    possibleAnswer: PossibleAnswer.SingleChoice,
    answer: Answer.SingleChoice?,
    onAnswerSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val options = possibleAnswer.options.associateBy { it }

    val radioOptions = options.keys.toList()

    val selected = if (answer != null) {
        answer.answer
    } else {
        null
    }

    val (selectedOption, onOptionSelected) = remember(answer) { mutableStateOf(selected) }

    Column(modifier = modifier) {
        radioOptions.forEach { text ->
            val onClickHandle = {
                onOptionSelected(text)
                options[text]?.let { onAnswerSelected(it) }
                Unit
            }
            val optionSelected = text == selectedOption

            Surface(
                color = Color.White.copy(alpha = 0.7f),
                border = BorderStroke(
                    width = 1.dp,
                    color = colorResource(R.color.violets_blue)
                ),
                modifier = Modifier.fillMaxSize()
                    .padding(vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = optionSelected,
                            onClick = onClickHandle
                        )
                        .padding(vertical = 16.dp, horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = text)

                    RadioButton(
                        selected = optionSelected,
                        onClick = onClickHandle,
                        colors = RadioButtonDefaults.colors(
                            selectedColor = colorResource(R.color.violets_blue )
                        )
                    )
                }
            }

        }
    }
}

@Composable
private fun MultipleChoiceQuestion(
    possibleAnswer: PossibleAnswer.MultipleChoice,
    answer: Answer.MultipleChoice?,
    onAnswerSelected: (String, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val options = possibleAnswer.options.associateBy { it }
    Column(modifier = modifier) {
        for (option in options) {
            var checkedState by remember(answer) {
                val selectedOption = answer?.answersStringRes?.contains(option.value)
                mutableStateOf(selectedOption ?: false)
            }

            Surface(
                color = Color.White.copy(alpha = 0.7f),
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(
                    width = 1.dp,
                    color = colorResource(R.color.violets_blue)
                ),
                modifier = Modifier
                    .padding(vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent)
                        .clickable(
                            onClick = {
                                checkedState = !checkedState
                                onAnswerSelected(option.value, checkedState)
                            }
                        )
                        .padding(vertical = 16.dp, horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = option.key)

                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = { selected ->
                            checkedState = selected
                            onAnswerSelected(option.value, selected)
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(R.color.violets_blue ),//.copy(alpha= 0.12f),
                            //uncheckedColor = colorResource(R.color.light_carmine_pink ),
                            checkmarkColor = colorResource(R.color.light_carmine_pink)
                        )
                    )
                }
            }
        }
    }
}

@Composable
private fun SliderQuestion(
    possibleAnswer: PossibleAnswer.Slider,
    answer: Answer.Slider?,
    onAnswerSelected: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    var sliderPosition by remember {
        mutableStateOf(answer?.answerValue ?: possibleAnswer.defaultValue)
    }
    Row(modifier = modifier) {
        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
                onAnswerSelected(it)
            },
            valueRange = possibleAnswer.range,
            steps = possibleAnswer.steps,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1f)
        )
    }
    Row {
        Text(
            text = possibleAnswer.startText,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.8f)
        )
        Text(
            text = possibleAnswer.neutralText,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.8f)
        )
        Text(
            text = possibleAnswer.endText,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.8f)
        )
    }
}

