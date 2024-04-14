import androidx.compose.foundation.layout.*
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun FlashNotification(flashService: FlashService) {
    val message by flashService.messages.collectAsState()

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier.fillMaxSize().padding(8.dp)
    ) {
        if (message != null) {
            Snackbar(
                backgroundColor = Color.Red,
                modifier = Modifier.fillMaxWidth(0.5f).align(Alignment.BottomCenter)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                ) {
                    Text(message.toString())
                }
            }
        }

        LaunchedEffect(key1 = message) {
            delay(3000L)
            flashService.clearMessage()
        }
    }
}