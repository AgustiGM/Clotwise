package cat.trombo.alertatrombo.viewmodels

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import cat.trombo.alertatrombo.domain.*
import cat.trombo.alertatrombo.repo.JsonObjectRepo
import cat.trombo.alertatrombo.repo.JsonPersonDataRepo

class MainScreenVM (context: Context) {

//    val foodList: List<Food> = JsonObjectRepo.loadFoods(context)
//    val jobList: List<Job> = JsonObjectRepo.loadJobs(context)
//    val hobbyList: List<Hobby> = JsonObjectRepo.loadHobbies(context)
//    val conditionList: List<Condition> = JsonObjectRepo.loadConditions(context)
//
//    val currentUser : Person? = null

    val repo = JsonPersonDataRepo();
    fun getPerson(context: Context):Person{
       var p:Person? = repo.loadData(context, "agusti.json" );
        println(p?.name)
        if(p != null) return p
        return Person("null", Gender.Other)
    }
}