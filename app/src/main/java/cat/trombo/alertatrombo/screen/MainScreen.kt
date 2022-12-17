package cat.trombo.alertatrombo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import cat.trombo.alertatrombo.R



//@Preview()
@Composable
fun MainScreen(navController: NavHostController) {
    val shape = RoundedCornerShape(12.dp)
    Box {
        /*Image(
                painter = painterResource(id = R.drawable.backgroundphotofield),
                contentDescription = null,
//            modifier = Modifier.fillMaxHeight()
            )*/
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top box with width-fitted content
            Box(
                modifier = Modifier.padding(8.dp).fillMaxWidth().clip(shape).background(color = Color.Red.copy(alpha = 0.5f))
                    .height(100.dp)/*, backgroundColor = Color.Red*/
            ) {
                Text("Top box"/*, style = TextStyle(color = Color.White, textAlign = TextAlign.Center)*/)
            }

            Box(
                modifier = Modifier.clip(RoundedCornerShape(20.dp)).padding(8.dp).background(color = Color.Green).height(100.dp)
            )
//             Bottom box with tabs
            Box(modifier = Modifier.fillMaxWidth().height(250.dp).background(color = Color.Blue)) {
            //TabOnlyTitle()
            //CustomTabs()
            tabs()
            }
        }
    }
}

@Composable
fun tabs() {
    var tabIndex by remember { mutableStateOf(0) } // 1.
    val tabTitles = listOf("Menjar", "Feina", "Oci", "Informació")
    Column { // 2.
        TabRow(selectedTabIndex = tabIndex) { // 3.
            tabTitles.forEachIndexed { index, title ->
                Tab(selected = tabIndex == index, // 4.
                    onClick = { tabIndex = index },
                    text = { Text(text = title) }) // 5.
            }
        }
        when (tabIndex) { // 6.
            0 -> Text("Hello content")
            1 -> Text("There content")
            2 -> Text("World content")
            3 -> Text("pagina 4")
        }
    }
}
