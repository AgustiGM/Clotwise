package cat.trombo.alertatrombo.viewmodels

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
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

    var currentUser : Person? = null


    fun setPerson (name: String, gender: Gender, age: Int, height: Double, weight: Double/*, job: Job*/ ){

        this.currentUser=Person(name,gender)
        this.currentUser?.age  =  age
        this.currentUser?.height = height
        this.currentUser?.weight = weight
       // this.currentUser?.job = job

        println(this.currentUser?.age)
        println(this.currentUser?.weight)
        println(this.currentUser?.height)
        println(this.currentUser?.name)

    }

    val repo = JsonPersonDataRepo();

    fun getPerson(context: Context):Person{
       var p:Person? = repo.loadData(context, "agusti.json" );
        if(p != null) return p
        return Person("null", Gender.Other)
    }
}