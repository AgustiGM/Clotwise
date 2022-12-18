package cat.trombo.alertatrombo.viewmodels

import cat.trombo.alertatrombo.events.LifeEvent

data class MSUiState(var currentEvent : LifeEvent?, var launched : Boolean = false, var vit : Double = 0.0)
