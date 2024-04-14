import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import kotlin.reflect.KFunction1

@OptIn(ExperimentalResourceApi::class)
@Composable
fun TaskCard(task: Task, index: Int, removeTask: KFunction1<Task, Unit>) {


    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().background(Color.LightGray).heightIn(max = 200.dp).clickable(onClick = {
            task.isDone = !task.isDone
            println("DONE: ${task.isDone}")
        })
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.widthIn(max = 400.dp)
        ) {
            Checkbox(
                checked = task.isDone,
                onCheckedChange = {
                    task.isDone = it
                },
                modifier = Modifier.padding(8.dp)
            )

            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        textDecoration = if (task.isDone) TextDecoration.LineThrough else TextDecoration.None
                    ),
                    text = index.toString() + ". " + task.title
                )
                Text(task.description)
            }
        }
        Button(
            modifier = Modifier.padding(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            onClick = {
                removeTask(task)
            }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete task",
                tint = Color.White
            )
        }
    }
}
