import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cat.trombo.alertatrombo.R
import cat.trombo.alertatrombo.Routes
import cat.trombo.alertatrombo.domain.Gender
import cat.trombo.alertatrombo.ui.theme.Background
import cat.trombo.alertatrombo.viewmodels.MainScreenVM
import kotlin.math.exp


@Composable
fun LoginPage(navController: NavHostController) {
    val viewModel = MainScreenVM
    Column {
        Box (
            modifier = Modifier
                .padding(15.dp)
                .height(100.dp).fillMaxWidth(),/*, backgroundColor = Color.Red*/
                contentAlignment = Alignment.Center
                ){
            Image(
                painter = painterResource(id = R.drawable.logoclotwise),
                contentDescription = null,
            )
        }

        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val name = remember { mutableStateOf(TextFieldValue()) }
            val edat = remember { mutableStateOf(TextFieldValue()) }
            val alcada = remember { mutableStateOf(TextFieldValue()) }
            val pes = remember { mutableStateOf(TextFieldValue()) }
            val sexe = remember { mutableStateOf("") }
            var expanded = remember { mutableStateOf(false) }
            //        var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

            Text(
                text = "Insereix les teves dades",
                color = Background,
            )

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                label = { Text(text = "Nom i cognoms") },
                value = name.value,
                onValueChange = { name.value = it })

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                label = { Text(text = "Edat") },
                value = edat.value,
                onValueChange = { edat.value = it })

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                label = { Text(text = "Alçada (cm)") },
                value = alcada.value,
                onValueChange = { alcada.value = it })

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                label = { Text(text = "Pes (kg)") },
                value = pes.value,
                onValueChange = { pes.value = it })


            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = sexe.value,
                onValueChange = { sexe.value = it },

                label = { Text("Gènere") },
                trailingIcon = {
                    Button(onClick = { expanded.value = !expanded.value }) {
                        Text("desplega")
                    }
                }
            )

            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = !expanded.value }
            ) {
                Gender.values().forEach { label ->
                    DropdownMenuItem(onClick = {
                        sexe.value = label.name
                        expanded.value = false
                    }) {
                        Text(text = label.name)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = {
                        //                    val gender : Gender = Gender.Male
                        viewModel.setPerson(
                            name.value.text,
                            Gender.valueOf(sexe.value),
                            edat.value.text.toInt(),
                            alcada.value.text.toDouble(),
                            pes.value.text.toDouble()
                        )
                        navController.navigate(Routes.MainScreen.route)
                    },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                ) {
                    Text(text = "Comença!")
                }
            }
        }
    }
}

@Composable
fun DropDown(list: List<String>) {

}
