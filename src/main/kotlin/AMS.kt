import java.util.*
import kotlin.random.Random

fun hello(){
    println("Hello World")
}

fun dayOfWeek(){
    println("What day is it today.?")

    when(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)){
        1 -> println("Day of the week is Sunday")
        2 -> println("Day of the week is Monday")
        3 -> println("Day of the week is Tuesday")
        4 -> println("Day of the week is Wednesday")
        5 -> println("Day of the week is Thursday")
        6 -> println("Day of the week is Friday")
        7 -> println("Day of the week is Saturday")
    }
}

fun feedTheFish(){
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")

    if(shouldChangeWater(day)){
        println("Change the water today")
    }

    //call dirty processor
    dirtyProcessor()
}

fun canFitMoreFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true) : Boolean{

    var totalAllFish = 0

    for (fishSize in currentFish) {
        totalAllFish += fishSize
    }

    val allowedFish = if (hasDecorations) ((tankSize.toInt())*0.8).toInt() else tankSize.toInt()

    return ((totalAllFish + fishSize) <= allowedFish)
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}

fun randomDay() : String{
    val week = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    return week[Random.nextInt(7)]
}

fun fishFood(day: String) : String {

    return when(day){
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redWorms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "plankton"
        else -> "fasting"
    }
}

fun shouldChangeWater(day: String, temperature : Int = 22, dirty: Int = 20): Boolean{

    return when{
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

fun getFortuneCookie(birthday: Int):String{
    val fortuneCookies = listOf("You will have a great day!", "Things will go well for you today.","Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.", "Today is a good day for exercising restraint.", "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")

    return when (birthday){
        28 -> fortuneCookies[0]
        31 -> fortuneCookies[3]
        in 1..7 -> fortuneCookies[5]
        else -> fortuneCookies[birthday.rem(fortuneCookies.size)]
    }
}

fun swim(time: Int, speed: String = "fast"){
    println("Swimming $speed")
}

fun getBirthday() : Int{
    println("Enter your birthday..")
    return readLine()?.toIntOrNull() ?: 1
}

fun getFortuneCookie10TimesWithFor(){
    for(i in 1 .. 10){
        val fortune = getFortuneCookie(getBirthday())
        val takeItEasy = "Take it easy"
        println( "$i -> Your fortune is: ${fortune}")

        if(fortune.contains(takeItEasy)){
            break
        }
    }
}

fun getFortuneCookie10TimesWithRepeat(){
    repeat(10){
        val fortune = getFortuneCookie(getBirthday())
        val takeItEasy = "Take it easy"
        println( "Your fortune is: $fortune")

//        if(fortune.contains(takeItEasy)){
//            break
//        }
    }
}

fun getFortuneCookie10TimesWithWhile(){

    var i = 0
    while(i<10){
        val fortune = getFortuneCookie(getBirthday())
        val takeItEasy = "Take it easy"
        println( "Your fortune is: $fortune")

        if(fortune.contains(takeItEasy)){
            break
        }
        i++
    }
}

fun updateDirty(dirty: Int, operation: (Int) -> Int) : Int{
    return operation(dirty)
}

val waterFilter: (Int) -> Int = {dirty -> dirty/2}

fun feedFish(dirty: Int) = dirty + 10
fun dirtyProcessor(){
    var dirty = 20
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)

    //last parameter call syntax
    dirty = updateDirty(dirty){dirty -> dirty + 50}

    //also allowed
    dirty = updateDirty(dirty, {dirty ->
        dirty + 50})
}

fun main(){

    hello()

    dayOfWeek()

    val temperature = 10
    val isHot = if(temperature > 50) true else false
    println(isHot)

    val message = "You are ${ if (temperature > 50) "fried" else "safe"} fish"
    println(message)

    val time = "13"

    val response = "Good ${if (time.toInt() < 12) "morning" else "night"}, Kotlin"
    println(response)

    feedTheFish()

    getFortuneCookie10TimesWithFor( )

    swim(time = 49, speed = "slow")

    println("Can fit fish: ${canFitMoreFish(10.0, listOf(3,3,3))}")
    println("Can fit fish: ${canFitMoreFish(8.0, listOf(2,2,2), hasDecorations = false)}")
    println("Can fit fish: ${canFitMoreFish(9.0, listOf(1,1,3), 3)}")
    println("Can fit fish: ${canFitMoreFish(10.0, listOf(), 7, true)}")

    println(waterFilter(50))
}