package cat.trombo.alertatrombo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.compose.ui.window.Popup
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import cat.trombo.alertatrombo.R
import cat.trombo.alertatrombo.domain.Person
import cat.trombo.alertatrombo.events.LifeEvent
import cat.trombo.alertatrombo.viewmodels.MainScreenVM
import cat.trombo.alertatrombo.ui.theme.*



//@Preview()
@Composable
fun MainScreen(navController: NavHostController) {
    val shape = RoundedCornerShape(12.dp)

    val viewModel = MainScreenVM
    val p: Person = viewModel.getPerson(LocalContext.current)

//    val e : LifeEvent? = viewModel.currentEvent
    val uiState by viewModel.uiState.collectAsState()

    var event : LifeEvent? = viewModel.cevent
    //println(state.value.person.height)


    var pop by remember {mutableStateOf(false)}
    var o1 = ""
    var o2 = ""


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
                    .background(color = LightBackground2.copy(alpha = 0.75f))
                    .height(200.dp)
                    /*, backgroundColor = Color.Red*/
            ) {
                CustomProgressBar()
            }

            Button(onClick = {pop = true;}){Text("click")}

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .padding(8.dp)
                    .fillMaxWidth()
                    .background(color = Color.Green)
                    .height(100.dp)
            ) {
                Box() {
                    if (uiState.currentEvent != null)
                        pop(uiState.currentEvent)

                }
            }
//             Bottom box with tabs
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)

                .background(color = LightBackground)) {

            //TabOnlyTitle()
            //CustomTabs()
            tabs(p)
            }
        }
        if(pop){
            Popup(
                alignment = Alignment.CenterStart,

                ) {
                Box(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clip(shape)
                    .background(color = Color.White)
                    .height(200.dp)){
                    Row() {
                        Button(onClick = { o1 = "1"; pop = false }) {
                            Text("option 1")
                        }
                        Button(onClick = { o2 = "2"; pop = false }) {
                            Text("option 2")
                        }
                    }
                }
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
                     modifier = Modifier.background(color = LightBackground2),
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
                    .padding(15.dp)
                    .fillMaxHeight(), verticalArrangement = Arrangement.SpaceEvenly){
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

@Composable
fun pop(e:LifeEvent?) {
    Box() {
        Text(e!!.title)
    }
}