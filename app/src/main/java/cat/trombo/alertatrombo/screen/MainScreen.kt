package cat.trombo.alertatrombo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.trombo.alertatrombo.R

@Preview()
@Composable
fun MainScreen() {
    Box {
        Image(
                painter = painterResource(id = R.drawable.backgroundphotofield),
                contentDescription = null,
//            modifier = Modifier.fillMaxHeight()
            )
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top box with width-fitted content
            Box(
                modifier = Modifier.fillMaxWidth().background(color = Color.Red).padding(8.dp)
                    .height(100.dp)/*, backgroundColor = Color.Red*/
            ) {
                Text("Top box"/*, style = TextStyle(color = Color.White, textAlign = TextAlign.Center)*/)
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Bottom box with tabs
            Box(modifier = Modifier.fillMaxWidth().height(200.dp).background(color = Color.Blue)) {
            TabOnlyTitle()
            }
        }
    }
}

@Composable
fun TabOnlyTitle() {
    var tabIndex by remember { mutableStateOf(0) }

    val tabData = listOf(
        "MUSIC",
        "APPS",
        "MOVIES",
        "BOOKS",
    )
    TabRow(selectedTabIndex = tabIndex) {
        tabData.forEachIndexed { index, text ->
            Tab(selected = tabIndex == index,
                onClick = {
                    tabIndex = index
                },
                text = {
                    Text(text = text)
                })
        }
    }
}