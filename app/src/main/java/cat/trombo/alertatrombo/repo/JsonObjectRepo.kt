package cat.trombo.alertatrombo.repo

import android.content.Context
import cat.trombo.alertatrombo.domain.Condition
import cat.trombo.alertatrombo.domain.Food
import cat.trombo.alertatrombo.domain.Hobby
import cat.trombo.alertatrombo.domain.Job
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonObjectRepo: GenericObjectRepo{

    private val gson : Gson = Gson()

    override fun loadJobs(context: Context): List<Job> {
        val jsonString = DataRetriever.loadData(context,"job.json")
        val type = object : TypeToken<List<Job>>() {}.type
        return gson.fromJson(jsonString, type)
    }

    override fun loadConditions(context: Context): List<Condition> {
        val jsonString = DataRetriever.loadData(context,"conditions.json")
        val type = object : TypeToken<List<Condition>>() {}.type
        return gson.fromJson(jsonString, type)
    }

    override fun loadFoods(context: Context): List<Food> {
        val jsonString = DataRetriever.loadData(context,"food.json")
        val type = object : TypeToken<List<Food>>() {}.type
        return gson.fromJson(jsonString, type)
    }

    override fun loadHobbies(context: Context): List<Hobby> {
        val jsonString = DataRetriever.loadData(context,"hobby.json")
        val type = object : TypeToken<List<Hobby>>() {}.type
        return gson.fromJson(jsonString, type)
    }

}