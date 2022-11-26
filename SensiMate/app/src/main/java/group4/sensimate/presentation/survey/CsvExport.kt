package group4.sensimate.presentation.survey

import group4.sensimate.data.model.Question
import java.io.OutputStream

fun OutputStream.writeCsv(question: List<Question>) {
    val writer = bufferedWriter()

    writer.write(""""SurveyId","Id","text","answer"""")
    writer.newLine()
    question.forEach{
        writer.write("${it.SurveyId},${it.id},\"${it.text},${it.answer}")
        writer.newLine()
    }
    writer.flush()

}