package cat.trombo.alertatrombo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview()
@Composable
fun MainScreen() {
    val SpaceBetween: Arrangement.HorizontalOrVertical
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp), verticalArrangement = Arrangement.SpaceBetween) {
        // Top box with width-fitted content
        Box(modifier = Modifier.fillMaxWidth().background(color = Color.Red).height(100.dp)/*, backgroundColor = Color.Red*/) {
            Text("Top box"/*, style = TextStyle(color = Color.White, textAlign = TextAlign.Center)*/)
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Image at the center
        Box(modifier = Modifier.align(alignment = Alignment.End).fillMaxWidth().background(color = Color.Green) /*Modifier.align(Alignment.Center).preferredSize(200.dp, 200.dp)*/) {
//            Image(
//                painter = painterResource(id = R.drawable.ancho),
//                contentDescription = null
//            )
        }
//        Spacer(modifier = Modifier.height(16.dp))

        // Bottom box with tabs
        Box(modifier = Modifier.fillMaxWidth().height(100.dp).background(color = Color.Blue)) {
//            TabRow {
//                Tab(
//                    text = "text",
//                ){
//                }
////                Tab(content = Text(text = "Tab2")
////                Tab(text = "Tab 2")
////                Tab(text = "Tab 3")
//            }
        }
    }
}