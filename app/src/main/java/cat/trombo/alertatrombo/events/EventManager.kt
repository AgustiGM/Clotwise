package cat.trombo.alertatrombo.events

import java.util.*

object EventManager {

    var eventQueue: Queue<LifeEvent> = LinkedList();


    fun getEvent() : LifeEvent? {
        return eventQueue.poll()
    }

    fun addEvent(event: LifeEvent) {
        eventQueue.add(event);
    }
}