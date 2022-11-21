package group4.sensimate.ui.survey

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import group4.sensimate.data.model.PossibleAnswer
import group4.sensimate.data.model.Question
import group4.sensimate.data.model.Survey
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.nio.charset.StandardCharsets
import java.nio.file.Paths
import group4.sensimate.data.repository.SurveyRepository

/*
fun readCsv(inputStream: InputStream): List<Survey>{
    val reader = inputStream.bufferedReader()
    val header = reader.readLine()
    return reader.lineSequence()
        .filter { it.isNotBlank() }
        .map { val (id, questions) = it.split(',', ignoreCase = false, limit = 3)
        Survey(id.)}
}

 */
//val SurveyId: Int,
//val id: Int,
//val text: String,
//val answer: PossibleAnswer


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