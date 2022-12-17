package cat.trombo.alertatrombo.screen
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.trombo.alertatrombo.ui.theme.Purple200
import cat.trombo.alertatrombo.ui.theme.Purple700

@Preview
@Composable
fun CustomProgressBar() {

    val context = LocalContext.current
    var progressCount: Int by remember { mutableStateOf(0) }
    var progress by remember { mutableStateOf(0f) }

    /* to avoid the direct calculation of progress variable which is a Float
     and it can sometimes cause problems like it shows 0.4 to 0.400004 so, here I have use
     progressCount and we will increase and decrease it and then convert it to progress(Float)
     and then use that progress with our ProgressBar Width*/
    when (progressCount) {
        0 -> progress = 0.0f
        10 -> progress = 0.1f
        20 -> progress = 0.2f
        30 -> progress = 0.3f
        40 -> progress = 0.4f
        50 -> progress = 0.5f
        60 -> progress = 0.6f
        70 -> progress = 0.7f
        80 -> progress = 0.8f
        90 -> progress = 0.9f
        100 -> progress = 1.0f
    }

    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 30.dp, end = 30.dp)
    ) {
        // for the text above the progressBar
        Row(
            modifier = Modifier
                .widthIn(min = 90.dp)
                .fillMaxWidth(size),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "VIDA: $progress")
        }
        // Progress Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(17.dp)
        ) {
            // for the background of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(9.dp))
                    .background(Purple200)
            )
            // for the progress of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxWidth(size)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(9.dp))
                    .background(Purple700)
                    .animateContentSize()
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // decrease button
            OutlinedButton(onClick = {
                if (progressCount > 0) {
                    progressCount -= 2
                } else {
                    Toast.makeText(context, "You cannot decrease any more", Toast.LENGTH_SHORT)
                        .show()
                }
            }) {
                Text(text = "Decrease")
            }
            // increase Button
            Button(onClick = {
                if (progressCount < 10) {
                    progressCount += 2
                } else {
                    Toast.makeText(context, "You cannot increase more", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text(text = "Increase")
            }
        }


    }

//    Use this when you want your progress bar should animate when you open your app
//    LaunchedEffect(key1 = true) {
//        progressCount = 7
//    }

}