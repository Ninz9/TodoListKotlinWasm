import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Task(var title: String, var description: String) {
    var isDone by mutableStateOf(false)
}