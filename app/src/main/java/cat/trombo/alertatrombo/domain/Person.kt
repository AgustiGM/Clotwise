package cat.trombo.alertatrombo.domain

class Person(val name: String,
                val gender: Gender) {

    var age: Int = 0

    var height: Double = 0.0

    var weight: Double = 0.0

    var job: Job? = null

    var conditions: List<Condition>? = null

    var hobbies: List<Hobby>? = null

    var glucose: Double = 9.9 //diabetes -> posar a 122.0

    var cholesterol: Double = 15.0 // alto -> 210.0

    var vitamins: Double = 30.0

    var stressLevel: Int = 5

    var activityLevel: Int = 70

    var hunger: Int = 0

    var waterIntake: Int = 0

    fun consume (food: Food) {
        this.glucose = this.glucose?.plus(food.addedGlucose)
        this.cholesterol = this.cholesterol?.plus(food.addedCholesterol)
        this.vitamins = this.vitamins?.plus(food.addedVitanim)
        if (food.name == "water") this.waterIntake = 0
        else this.hunger = 0
    }

    fun doJob (job: Job) {
        this.stressLevel = this.stressLevel?.plus(job.stress)
        this.activityLevel = this.activityLevel?.plus(job.activity)
    }

    fun setCondition (cond: Condition){
        this.glucose = cond.glucose
        this.stressLevel = cond.harmful
        this.activityLevel = cond.healthy
    }

    fun doHobby (hobby: Hobby){
        this.activityLevel = this.activityLevel?.minus(hobby.sedentarism)
        this.activityLevel = this.activityLevel?.plus(hobby.healthy)
        this.hunger = this.hunger?.plus(hobby.hunger)
        this.waterIntake = this.waterIntake?.plus(hobby.water)
    }
}