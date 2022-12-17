package cat.trombo.alertatrombo.viewmodels

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.trombo.alertatrombo.domain.*
import cat.trombo.alertatrombo.events.EventManager
import cat.trombo.alertatrombo.events.LifeEvent
import cat.trombo.alertatrombo.repo.JsonObjectRepo
import cat.trombo.alertatrombo.repo.JsonPersonDataRepo
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainScreenVM (context: Context) : ViewModel() {

    val foodList: List<Food> = JsonObjectRepo.loadFoods(context)
    val jobList: List<Job> = JsonObjectRepo.loadJobs(context)
    val hobbyList: List<Hobby> = JsonObjectRepo.loadHobbies(context)
    val conditionList: List<Condition> = JsonObjectRepo.loadConditions(context)

    val currentUser : Person? = null

    val currentEvent : LifeEvent? = null

    fun initEvents() {
        val e1: LifeEvent = LifeEvent("Et toca la loteria",
                                    "Has guanyat la loteria tot i no participar-hi",
                                    List(1,fun(a: Int): String {return "Opció: $a" }))

        val e2: LifeEvent = LifeEvent("Et fa mal la cama",
                                "Fa uns dies que et fa mal la cama, què fas?",
                                 List(3,fun(a: Int): String {return "Opció: $a" }))

        EventManager.addEvent(e1)
        EventManager.addEvent(e2)
    }

    fun run() {
        while (EventManager.eventQueue.size >= 1) {
            viewModelScope.launch {
                val currentEvent = EventManager.getEvent()
            }
        }
    }

    val repo = JsonPersonDataRepo();

    fun getPerson(context: Context):Person{
       var p:Person? = repo.loadData(context, "agusti.json" );
        println(p?.name)
        if(p != null) return p
        return Person("null", Gender.Other)
    }
}