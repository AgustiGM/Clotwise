package cat.trombo.alertatrombo.repo

import android.content.Context
import cat.trombo.alertatrombo.domain.Job
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class JsonObjectRepo: GenericObjectRepo{

    private val gson : Gson = Gson()

    override fun loadJobs(context: Context) {
        val jsonString = DataRetriever.loadData(context,"jobs.json")
        val type = object : TypeToken<Job>() {}.type
        return gson.fromJson(jsonString, type)
    }

    override fun loadConditions(context: Context) {
        val jsonString = DataRetriever.loadData(context,"conditions.json")
        val type = object : TypeToken<Job>() {}.type
        return gson.fromJson(jsonString, type)
    }

    override fun loadFoods(context: Context) {
        val jsonString = DataRetriever.loadData(context,"foods.json")
        val type = object : TypeToken<Job>() {}.type
        return gson.fromJson(jsonString, type)
    }

    override fun loadHobbies(context: Context) {
        val jsonString = DataRetriever.loadData(context,"hobbies.json")
        val type = object : TypeToken<Job>() {}.type
        return gson.fromJson(jsonString, type)
    }

}