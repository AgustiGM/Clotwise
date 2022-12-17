package cat.trombo.alertatrombo.viewmodels

import android.content.Context
import cat.trombo.alertatrombo.domain.*
import cat.trombo.alertatrombo.repo.JsonObjectRepo

class MainScreenVM (context: Context) {

    val foodList: List<Food> = JsonObjectRepo.loadFoods(context)
    val jobList: List<Job> = JsonObjectRepo.loadJobs(context)
    val hobbyList: List<Hobby> = JsonObjectRepo.loadHobbies(context)
    val conditionList: List<Condition> = JsonObjectRepo.loadConditions(context)

    val currentUser : Person? = null
}