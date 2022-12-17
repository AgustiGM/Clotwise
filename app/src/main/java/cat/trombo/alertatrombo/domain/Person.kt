package cat.trombo.alertatrombo.domain

class Person(val name: String,
                val gender: Gender) {

    var age: Int = 0
        private set

    var height: Double = 0.0

    var weight: Double = 0.0

    var job: Job? = null

    var conditions: List<Condition>? = null

    var hobbies: List<Hobby>? = null

    var glucose: Double? = null

    var cholesterol: Double? = null;

    var stressLevel: Int = 0

    var activityLevel: Int = 0

    var condition: List<Condition>? = null

    var hunger: Int = 0

    var waterIntake: Int = 0


}