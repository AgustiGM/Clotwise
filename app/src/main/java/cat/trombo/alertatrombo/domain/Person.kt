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

    var cholesterol: Double? = null

    var vitamins: Double? = null

    var stressLevel: Int = 0

    var activityLevel: Int = 0

    var condition: List<Condition>? = null

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