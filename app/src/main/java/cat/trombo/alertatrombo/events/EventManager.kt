package cat.trombo.alertatrombo.events

import android.os.Build
import kotlinx.coroutines.delay
import java.lang.Thread.sleep
import java.time.LocalDate
import java.util.*
import kotlin.math.abs

object EventManager {

    var eventQueue: Queue<LifeEvent> = LinkedList();


    fun getEvent() : LifeEvent? {


            println(Calendar.getInstance().time)

        println("*****************")
        println("I'mhere")
        println("****************")
        return eventQueue.poll()
    }

    fun addEvent(event: LifeEvent) {
        eventQueue.add(event);
    }
}