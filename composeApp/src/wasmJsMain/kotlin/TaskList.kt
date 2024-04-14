import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun TaskList(taskList: TaskContainer) {


    var withDone by remember { mutableStateOf(true) }

    val scrollState = rememberScrollState()


    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            withDone = !withDone
        }) {
        Text(text = if (withDone) "Hide Done" else "Show Done")
    }

    Text("Left todo: ${taskList.getUnfinishedTasksCount()}")


    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        taskList.getTasks().forEachIndexed { index, it ->
            if (withDone || !it.isDone) {
                Column(
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    TaskCard(it, index + 1, taskList::removeTask)
                }
            }
        }
    }
}