import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FlashService {
    private val _messages = MutableStateFlow<String?>(null)
    val messages: StateFlow<String?> = _messages

    fun showMessage(message: String) {
        _messages.value = message
    }

    fun clearMessage() {
        _messages.value = null
    }
}