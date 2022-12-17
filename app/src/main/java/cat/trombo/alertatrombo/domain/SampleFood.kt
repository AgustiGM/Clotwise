package cat.trombo.alertatrombo.domain

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class SampleFood : PreviewParameterProvider<Food>{
    override val values = sequenceOf(Food("Hamburger",310,45, 10, 5,33, 0.9,1.1,0.0)
        , Food("Broccoli",31,5, 0, 15,0, 00.0,0.0,2.0))

}
