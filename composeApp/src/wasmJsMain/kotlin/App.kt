import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    val flashService = remember { FlashService() }
    val todoList = remember { TaskContainer() }

    Column(modifier = Modifier.padding(70.dp), horizontalAlignment = CenterHorizontally) {
        TaskInput(flashService, todoList::addTask)
        TaskList(todoList)
    }
    FlashNotification(flashService)
}