import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import kotlin.reflect.KFunction1

@OptIn(ExperimentalResourceApi::class)
@Composable
fun TaskInput(flashService: FlashService, addTask: KFunction1<Task, Unit>) {

    var taskText by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }


    TextField(
        modifier = Modifier.widthIn(min = 400.dp, max = 400.dp),
        value = taskText,
        onValueChange = { taskText = it },
        label = { Text("Task") }
    )
    TextField(
        modifier = Modifier
            .widthIn(min = 400.dp, max = 400.dp)
            .heightIn(min = 200.dp, max = 200.dp),
        value = taskDescription,
        onValueChange = { taskDescription = it },
        label = { Text("Description") }
    )
    Button(onClick = {
        if (taskText.isBlank() || taskDescription.isBlank()) {
            flashService.showMessage("Task and description should not be empty")
        } else {
            addTask(Task(taskText, taskDescription))
            taskText = ""
            taskDescription = ""
        }
    }) {
        Text("Add Task")
    }
}