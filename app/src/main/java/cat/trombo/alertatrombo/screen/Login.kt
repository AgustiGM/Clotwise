import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import cat.trombo.alertatrombo.R
import cat.trombo.alertatrombo.Routes
import cat.trombo.alertatrombo.domain.Gender
import cat.trombo.alertatrombo.ui.theme.Background
import cat.trombo.alertatrombo.ui.theme.Purple700
import cat.trombo.alertatrombo.viewmodels.MainScreenVM

@Composable
fun LoginPage(navController: NavHostController) {
    val viewModel = MainScreenVM(LocalContext.current)
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val name = remember { mutableStateOf(TextFieldValue()) }
        val edat = remember { mutableStateOf(TextFieldValue()) }
        val alcada = remember { mutableStateOf(TextFieldValue()) }
        val pes = remember { mutableStateOf(TextFieldValue()) }

        Text(text = "Insereix les teves dades",
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
            label = { Text(text = "Alçada") },
            value = alcada.value,
            onValueChange = { alcada.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Pes") },
            value = pes.value,
            onValueChange = { pes.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    val gender : Gender = Gender.Male
                    viewModel.setPerson(name.value.text, gender, edat.value.text.toInt(), alcada.value.text.toDouble(), pes.value.text.toDouble())
                    navController.navigate(Routes.MainScreen.route) },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Comença!")
            }
        }
    }
}
