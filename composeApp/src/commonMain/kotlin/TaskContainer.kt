import androidx.compose.runtime.mutableStateOf


class TaskContainer {
    private val tasks = mutableStateOf(listOf<Task>())

    fun addTask(task: Task) {
        tasks.value += task
    }

    fun removeTask(task: Task) {
        tasks.value = tasks.value.filter { it != task }
    }

    fun getUnfinishedTasksCount(): Int {
        return tasks.value.count { !it.isDone }
    }

    fun getTasks(): List<Task> {
        return tasks.value
    }
}