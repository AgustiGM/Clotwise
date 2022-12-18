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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.trombo.alertatrombo.domain.Person
import cat.trombo.alertatrombo.ui.theme.Purple200
import cat.trombo.alertatrombo.ui.theme.Purple700
import cat.trombo.alertatrombo.ui.theme.*
import cat.trombo.alertatrombo.viewmodels.MainScreenVM


@Preview
@Composable
fun CustomProgressBar() {

    var progressCount: Int by remember { mutableStateOf(0) }
    var progressCount2: Int by remember { mutableStateOf(0) }
    var progress by remember { mutableStateOf(0f) }
    var progress2 by remember { mutableStateOf(0f) }



    val viewModel = MainScreenVM

    val uiState by viewModel.uiState.collectAsState()
    val p: Person = viewModel.currentUser!!


    //var vida = vitamins +activityLevel - hunger- waterintake-glucose-cholesterol-stressLevel
    //var risc = hunger + waterintake + stressLevel + cholesterol + glucose -vitamins - activityLevel


    progressCount = uiState.vit.toInt() + p.activityLevel - p.hunger - p.waterIntake - p.glucose.toInt() - p.cholesterol.toInt() - p.stressLevel
    progressCount2 = 100 - progressCount
    if (progressCount2 > 100) progressCount2 = 100
    if (progressCount2 < 0) progressCount2 = 0
    if (progressCount > 100) progressCount = 100
    if (progressCount < 0) progressCount = 0

    /* to avoid the direct calculation of progress variable which is a Float
     and it can sometimes cause problems like it shows 0.4 to 0.400004 so, here I have use
     progressCount and we will increase and decrease it and then convert it to progress(Float)
     and then use that progress with our ProgressBar Width*/
//    when (progressCount2) {
//
//        0 -> progress2 = 0.0f
//        5 -> progress2 = 0.05f
//        10 -> progress2 = 0.1f
//        15 -> progress2 = 0.15f
//        20 -> progress2 = 0.2f
//        25 -> progress2 = 0.25f
//        30 -> progress2 = 0.3f
//        35 -> progress2 = 0.35f
//        40 -> progress2 = 0.4f
//        45 -> progress2 = 0.45f
//        50 -> progress2 = 0.5f
//        55 -> progress2 = 0.55f
//        60 -> progress2 = 0.6f
//        65 -> progress2 = 0.65f
//        70 -> progress2 = 0.7f
//        75 -> progress2 = 0.75f
//        80 -> progress2 = 0.8f
//        85 -> progress2 = 0.85f
//        90 -> progress2 = 0.9f
//        95 -> progress2 = 0.95f
//        100 -> progress2 = 1.0f
//    }
    progress2 = progressCount2 / 100f

    when (progressCount) {
        0 -> progress = 0.0f
        5 -> progress = 0.05f
        10 -> progress = 0.1f
        15 -> progress = 0.15f
        20 -> progress = 0.2f
        25 -> progress = 0.25f
        30 -> progress = 0.3f
        35 -> progress = 0.35f
        40 -> progress = 0.4f
        45 -> progress = 0.45f
        50 -> progress = 0.5f
        55 -> progress = 0.55f
        60 -> progress = 0.6f
        65 -> progress = 0.65f
        70 -> progress = 0.7f
        75 -> progress = 0.75f
        80 -> progress = 0.8f
        85 -> progress = 0.85f
        90 -> progress = 0.9f
        95 -> progress = 0.95f
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

    val size2 by animateFloatAsState(
        targetValue = progress2,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.dp, start = 5.dp, end = 5.dp)
    ) {
//        // for the text above the progressBar
//        Row(
//            modifier = Modifier
//                .widthIn(min = 90.dp)
//                .fillMaxWidth(size),
//            horizontalArrangement = Arrangement.End
//        ) {
//            Text(text = "VIDA: $progress")
//        }
//        // Progress Bar
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(17.dp)
//        ) {
//            // for the background of the ProgressBar
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .clip(RoundedCornerShape(9.dp))
//                    .background(Purple200)
//            )
//            // for the progress of the ProgressBar
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth(size)
//                    .fillMaxHeight()
//                    .clip(RoundedCornerShape(9.dp))
//                    .background(Purple700)
//                    .animateContentSize()
//            )
//        }
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 30.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ){}

        Row(
            modifier = Modifier
                .widthIn(min = 90.dp)
                .fillMaxWidth(size2),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "RISC: $progressCount2%")
        }

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
                    .background(Color.White)
            )
            // for the progress of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxWidth(size2)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(9.dp))
                    .background(LightBackground2)
                    .animateContentSize()
            )
        }
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 30.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            // decrease button
//            OutlinedButton(onClick = {
//                if (progressCount > 0) {
//                    progressCount -= 10
//                } else {
//                    Toast.makeText(context, "You cannot decrease any more", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }) {
//                Text(text = "Decrease")
//            }
//            // increase Button
//            Button(onClick = {
//                if (progressCount < 100) {
//                    progressCount += 10
//                } else {
//                    Toast.makeText(context, "You cannot increase more", Toast.LENGTH_SHORT).show()
//                }
//            }) {
//                Text(text = "Increase")
//            }
//        }


    }

//    Use this when you want your progress bar should animate when you open your app
//    LaunchedEffect(key1 = true) {
//        progressCount = 7
//    }

}