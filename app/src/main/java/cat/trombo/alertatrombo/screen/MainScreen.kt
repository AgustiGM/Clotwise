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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import cat.trombo.alertatrombo.R
import cat.trombo.alertatrombo.domain.Person
import cat.trombo.alertatrombo.viewmodels.MainScreenVM
import cat.trombo.alertatrombo.ui.theme.*


//@Preview()
@Composable
fun MainScreen(navController: NavHostController) {
    val shape = RoundedCornerShape(12.dp)
    val viewModel = MainScreenVM(LocalContext.current)
    val p: Person = viewModel.getPerson(LocalContext.current)
    println(p.height)
    Box {
        Image(
                painter = painterResource(id = R.drawable.backgroundphotofield),
                contentDescription = null,
//            modifier = Modifier.fillMaxHeight()
            )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top box with width-fitted content
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clip(shape)
                    .background(color = Color.Red.copy(alpha = 0.5f))
                    .height(100.dp)/*, backgroundColor = Color.Red*/
            ) {
                Text("Top box"/*, style = TextStyle(color = Color.White, textAlign = TextAlign.Center)*/)
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .padding(8.dp)
                    .background(color = Color.Green)
                    .height(100.dp)
            )
//             Bottom box with tabs
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(color = Background )) {
            //TabOnlyTitle()
            //CustomTabs()
            tabs(p)
            }
        }
    }
}

//@Preview()
@Composable
fun tabs(p:Person) {
    var tabIndex by remember { mutableStateOf(0) } // 1.
    val tabTitles = listOf("Menjar", "Feina", "Oci", "Info")
    Column { // 2.
        TabRow(selectedTabIndex = tabIndex) { // 3.
            tabTitles.forEachIndexed { index, title ->
                Tab(selected = tabIndex == index, // 4.
                    onClick = { tabIndex = index },
                     modifier = Modifier.background(color = DarkBackground),
                    text = { Text(text = title) }) // 5.
            }
        }
        when (tabIndex) { // 6.
            0 -> Box(modifier = Modifier.padding(6.dp)){
                Text("Hola\nHola\nHola")
            }//Text("Hello content")
            1 -> Row( modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
                Column(){
                    Text("Hola")
                    Text("Hola")
                    Text("Hola")
                    Text("Hola")
                    Text("Hola")
                    Text("Hola")
                    Text("Hola")
                }
                Column(){
                    Text("Adeu")
                    Text("Adeu")
                    Text("Adeu")
                    Text("Adeu")
                    Text("Adeu")
                    Text("Adeu")
                    Text("Adeu")
                }
            }
            2-> Text("There content")
            3 -> Row( modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
                Column(modifier = Modifier
                    .padding(15.dp).fillMaxHeight(), verticalArrangement = Arrangement.SpaceEvenly){
                    Text("Nom: "+p.name)
                    Text("Edat: "+p.age)
                    Text("Gènere: "+p.gender)
                    Text("Altura: "+p.height)
                    Text("Pes: "+p.weight)
                }
                Column(){
                    Text("Adeu")
                    Text("Adeu")
                    Text("Adeu")
                    Text("Adeu")
                    Text("Adeu")
                    Text("Adeu")
                    Text("Adeu")
                }
            }
        }
    }
}
