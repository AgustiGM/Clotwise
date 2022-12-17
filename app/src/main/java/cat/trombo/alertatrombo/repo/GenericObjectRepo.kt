package cat.trombo.alertatrombo.repo

import android.content.Context
import cat.trombo.alertatrombo.domain.Condition
import cat.trombo.alertatrombo.domain.Food
import cat.trombo.alertatrombo.domain.Hobby
import cat.trombo.alertatrombo.domain.Job

interface GenericObjectRepo {

    fun loadJobs(context: Context) : List<Job>

    fun loadConditions(context: Context) : List<Condition>

    fun loadFoods(context: Context) : List<Food>

    fun loadHobbies(context: Context) : List<Hobby>
}