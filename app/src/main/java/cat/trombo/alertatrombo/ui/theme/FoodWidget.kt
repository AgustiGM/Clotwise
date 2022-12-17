package cat.trombo.alertatrombo.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import cat.trombo.alertatrombo.domain.Food
import cat.trombo.alertatrombo.domain.SampleFood

@Preview
@Composable
fun MyFoodWidget(@PreviewParameter(SampleFood::class)
                food: Food
                )   {
    Column (modifier = Modifier.background(color = Color.DarkGray)){
        Row (modifier = Modifier.align(alignment = Alignment.CenterHorizontally)){
            Text(food.name)
        }
        Row {
            Text("Calories: " + food.calories.toString())
        }
    }
}