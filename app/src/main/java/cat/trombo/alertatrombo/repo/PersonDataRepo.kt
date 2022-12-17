package cat.trombo.alertatrombo.repo

import android.content.Context
import cat.trombo.alertatrombo.domain.Person

interface PersonDataRepo {
    fun loadData(context: Context, fileName: String) : Person?
}