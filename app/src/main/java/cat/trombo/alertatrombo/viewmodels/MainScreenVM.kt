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

    fun initialize() {
        initEvents();
        run();
        updateState(null,false, currentUser!!.vitamins)
    }

    private val _uiState = MutableStateFlow(MSUiState(null))
    val uiState: StateFlow<MSUiState> = _uiState.asStateFlow()

//    val foodList: List<Food> = JsonObjectRepo.loadFoods(context)
//    val jobList: List<Job> = JsonObjectRepo.loadJobs(context)
//    val hobbyList: List<Hobby> = JsonObjectRepo.loadHobbies(context)
//    val conditionList: List<Condition> = JsonObjectRepo.loadConditions(context)


    var cevent : LifeEvent? = null

    private fun initEvents() {
        val e1: LifeEvent = LifeEvent("Tens gana",
                                    "Què vols fer per matar el cuquet?",
                                    List(2,fun(a: Int): String {
                                        return when(a) {
                                            0 -> "Anar al supermercat"
                                            1 -> "Tirar de fast food"
                                            else -> "No fer res"
                                        }
                                    }))

        val e2: LifeEvent = LifeEvent("Et fa mal la cama",
                                "Fa uns dies que et fa mal la cama, què fas?",
                                List(2,fun(a: Int): String {
                                    return when(a) {
                                        0 -> "Anar al metge"
                                        1 -> "Són cruiximents"
                                        else -> "No fer res"
                                    }
                                }))

        val e3: LifeEvent = LifeEvent("Divendres a la tarda",
                "Per fi és divendres, què fas per esbargir-te?",
                            List(2,fun(a: Int): String {
                             return when(a) {
                                 0 -> "Sofà i manta"
                                 1 -> "Donar-ho tot al bar"
                            else -> "No fer res"
                    }
                }))

        EventManager.addEvent(e1)
        EventManager.addEvent(e2)
        EventManager.addEvent(e3)
    }

    fun returnEventState(option: Int){
        updateState(cevent,launched = false, currentUser!!.vitamins)
        when(option) {
            0 -> updatePerson(currentUser,1)
            1 -> updatePerson(currentUser,0)
            else -> 1+1
        }
        run();
    }

    private fun updatePerson(currentUser: Person?, i: Int) {
        if (currentUser != null) {
            if (i == 1) {
                currentUser.vitamins += 1
                currentUser.activityLevel +1
            }
            else {
                currentUser.cholesterol +=1
                currentUser.glucose += 1
                currentUser.stressLevel += 1
                currentUser.vitamins = currentUser.vitamins
            }
            updateState(cevent,false,currentUser.vitamins)
        }
    }

    private fun run() {
        viewModelScope.launch {
        if (EventManager.eventQueue.size >= 1) {
            val del = abs(Random(54).nextLong()%10000) + 6000
            delay(del)
            cevent = EventManager.getEvent()
            updateState(cevent, true, currentUser!!.vitamins)
            }
        }
    }

    private fun updateState(cevent: LifeEvent?, launched: Boolean, vit: Double) {
        _uiState.update {  currentState ->
            currentState.copy(
                currentEvent = cevent,
                launched = launched,
                vit = vit
            )
        }

    }

    var currentUser : Person? = null

    fun setPerson (name: String, gender: Gender, age: Int, height: Double, weight: Double/*, job: Job*/ ){

        this.currentUser=Person(name,gender)

        this.currentUser?.age  =  age
        this.currentUser?.height = height
        this.currentUser?.weight = weight

        println(this.currentUser?.age)
        println(this.currentUser?.weight)
        println(this.currentUser?.height)
        println(this.currentUser?.name)
        this.initialize()
    }

    val repo = JsonPersonDataRepo();

    fun getPerson(context: Context):Person{
       var p:Person? = repo.loadData(context, "agusti.json" );
        println(p?.name)
        if(p != null) return p
        return Person("null", Gender.Altres)
    }

}