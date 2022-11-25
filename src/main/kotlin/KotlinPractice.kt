fun whatShouldIDoToday(weather: String = "sunny", temperature : Int = 24) : String{

    val mood = getMood()
    return when {
        happySunny(mood, weather) -> "Go for a walk"
        sadRainyTempLow(mood, weather, temperature) -> "Stay in bed"
        isTempHigh(temperature) -> "Go swimming"
        else -> "Stay home and read"
    }
}

fun getMood() : String{
    println("Enter your mood..")
    return readLine()?.toString() ?: "happy"
}

fun happySunny(mood: String, weather: String) = mood == "happy" && weather == "sunny"
fun sadRainyTempLow(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun isTempHigh(temperature: Int) = temperature > 35

fun eagerExample(){
    var decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flower pot")
    val eager = decorations.filter { it[0] == 'p' }

    println(eager.toString())

    //apply filter lazily
    val filtered = decorations.asSequence().filter { it[0] == 'p' }

    println(filtered)
    println(filtered.toList())

    val lazyMap = decorations.asSequence().map { println("map: $it")
        it}

    println(lazyMap)
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")

}

fun spices(){
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
    val filtered = spices.filter { it -> it.contains("curry")  }
    println(filtered.toList())

    val filtered2 = spices.filter { it -> it.startsWith("c") && it.endsWith("e") }
    println(filtered2.toList())

    val filtered3 = spices.subList(0,3).filter { it.startsWith("c") }
    println(filtered3)
}

val rollDice = {number : Int -> number}

val rollDice2 = {number: Int -> if (number == 0) 0 else number}

val rollDice3: (Int) -> Int = { number -> if (number == 0) 0 else number }
fun gamePlay(roll: Int, operation: (Int) -> Int){
    println("Roll: $roll")
}
fun main () {

    println("${whatShouldIDoToday(weather = "rainy", temperature = 0)}")

    eagerExample()

    spices()

    val random1 = Math.random()
    println(random1)

    val random2 = { Math.random() }
    println(random2)

    //calling game play and passing it a lambda function rollDice3
    val roll = 3
    gamePlay(roll, rollDice3)
    gamePlay(roll){roll -> roll}
    gamePlay(roll, {roll -> roll})
}