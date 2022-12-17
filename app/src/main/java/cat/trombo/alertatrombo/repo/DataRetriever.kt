package cat.trombo.alertatrombo.repo

import android.content.Context
import java.io.IOException

object DataRetriever {
    fun loadData(context: Context, fileName: String) : String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}