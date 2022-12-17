package cat.trombo.alertatrombo.repo

import android.content.Context

interface GenericObjectRepo {

    fun loadJobs(context: Context)

    fun loadConditions(context: Context)

    fun loadFoods(context: Context)

    fun loadHobbies(context: Context)
}