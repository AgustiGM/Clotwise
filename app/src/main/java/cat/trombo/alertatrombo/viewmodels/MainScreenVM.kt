package cat.trombo.alertatrombo.viewmodels

import android.content.Context

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

import cat.trombo.alertatrombo.domain.*
import cat.trombo.alertatrombo.events.EventManager
import cat.trombo.alertatrombo.events.LifeEvent
import cat.trombo.alertatrombo.repo.JsonPersonDataRepo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.*
import kotlin.math.abs

object MainScreenVM : ViewModel() {

    init {
        initEvents();
        run();
    }

    private val _uiState = MutableStateFlow(MSUiState(null))
    val uiState: StateFlow<MSUiState> = _uiState.asStateFlow()

//    val foodList: List<Food> = JsonObjectRepo.loadFoods(context)
//    val jobList: List<Job> = JsonObjectRepo.loadJobs(context)
//    val hobbyList: List<Hobby> = JsonObjectRepo.loadHobbies(context)
//    val conditionList: List<Condition> = JsonObjectRepo.loadConditions(context)

    val currentUser : Person? = null

    var cevent : LifeEvent? = null

    private fun initEvents() {
        val e1: LifeEvent = LifeEvent("Et toca la loteria",
                                    "Has guanyat la loteria tot i no participar-hi",
                                    List(1,fun(a: Int): String {return "Opció: $a" }))

        val e2: LifeEvent = LifeEvent("Et fa mal la cama",
                                "Fa uns dies que et fa mal la cama, què fas?",
                                 List(3,fun(a: Int): String {return "Opció: $a" }))

        EventManager.addEvent(e1)
        EventManager.addEvent(e2)
    }

    private fun run() {
        viewModelScope.launch {
        while (EventManager.eventQueue.size >= 1) {

            delay(abs(Random(54).nextLong()%8000))
            cevent = null
            cevent = EventManager.getEvent()
            updateState(cevent)

            }
        }
    }

    private fun updateState(cevent: LifeEvent?) {
        _uiState.update {  currentState ->
            currentState.copy(
                currentEvent = cevent
            )
        }

    }

    private

    var currentUser : Person? = null


    fun setPerson (name: String, gender: Gender, age: Int, height: Double, weight: Double, job: Job ){

        this.currentUser=Person(name,gender)

        this.currentUser?.age  =  age
        this.currentUser?.height = height
        this.currentUser?.weight = weight
        this.currentUser?.job = job


    }

    val repo = JsonPersonDataRepo();
    fun getPerson(context: Context):Person{
       var p:Person? = repo.loadData(context, "agusti.json" );
        println(p?.name)
        if(p != null) return p
        return Person("null", Gender.Other)
    }

}