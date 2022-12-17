package cat.trombo.alertatrombo.events

import java.lang.Thread.sleep
import java.util.*

object EventManager {

    var eventQueue: Queue<LifeEvent> = LinkedList();


    fun getEvent() : LifeEvent? {
        sleep(3000)
        return eventQueue.poll()
    }

    fun addEvent(event: LifeEvent) {
        eventQueue.add(event);
    }
}