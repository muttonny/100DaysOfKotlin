package Aquarium

abstract class AquariumFish (){
    abstract val color: String
}

class Shark() : AquariumFish(), FishAction{

    override val color: String = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }

}

class Plecostomus() : AquariumFish(), FishAction{

    override val color: String = "gold"
    override fun eat() {
        println("munch on algae")
    }
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

class Tilapia(fishColor: FishColor = GreyColor) : FishAction by PrintFishAction("a lot of algae"), FishColor by GreyColor

class PrintFishAction(val food: String): FishAction{
    override fun eat() {
        println(food)
    }

}

object GoldColor: FishColor{
    override val color: String
        get() = "gold"

}

object GreyColor: FishColor{
    override val color: String
        get() = "grey"
}

object RedColor: FishColor{
    override val color: String
        get() = "red"

}
object BlueColor: FishColor{
    override val color: String
        get() = "blue"

}