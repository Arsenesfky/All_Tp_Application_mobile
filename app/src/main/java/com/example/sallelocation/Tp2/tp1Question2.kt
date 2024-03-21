import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DrawingScreen() {
    val lines = remember {
        mutableStateListOf<Line>()
    }

    Canvas(
        modifier = Modifier
            .width(300.dp)
            .height(200.dp)
            .pointerInput(true) {
                detectDragGestures { change, dragAmount ->
                    change.consume()

                    val line = Line(
                        start = change.position - dragAmount,
                        end = change.position
                    )

                    lines.add(line)
                }
            }
    ) {
        lines.forEach { line ->
            drawLine(
                color = line.color,
                start = line.start,
                end = line.end,
                strokeWidth = line.strokeWidth.toPx(),
                cap = StrokeCap.Round
            )
        }
    }
}

data class Line(
    val start: Offset,
    val end: Offset,
    val color: Color = Color.Black,
    val strokeWidth: Dp = 1.dp
)