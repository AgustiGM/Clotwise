package cat.trombo.alertatrombo.repo

import android.content.Context
import cat.trombo.alertatrombo.domain.Person
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class JsonPersonDataRepo: PersonDataRepo {
    override fun loadData(context: Context, fileName: String): Person? {
        val jsonString = DataRetriever.loadData(context, fileName)
        val gson = Gson()
        val personType = object : TypeToken<Person>() {}.type
        return gson.fromJson(jsonString, personType)
    }
}