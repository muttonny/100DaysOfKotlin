package Aquarium

class Spice (val name: String, val spiciness: String = "mild"){

    val heat: Int
        get() {
            return when(spiciness){
                "not hot" -> 0
                "mild" -> 8
                "mild2" -> 10
                "hot" -> 20
                "medium hot" -> 30
                "very hot" -> 40
                else -> 0
            }
        }

    init {
        println("Spice: ${this.name} Hot: ${this.heat}")
    }

    fun defaultSpice() = Spice("Salt", "mild")
}

fun main(){

    val curry = Spice("Curry", "mild")
    val pepper = Spice("pepper", "hot")
    val cayenne = Spice("cayenne", "mild")
    val ginger = Spice("ginger", "mild2")
    val redCurry = Spice("red curry", "medium hot")
    val greenCurry = Spice("green curry", "not hot")
    val redPepper = Spice("red pepper", "very hot")

    val spices = listOf(curry, pepper, cayenne, ginger, redCurry, greenCurry, redPepper )

    val list = spices.filter { it.heat >  10}
    println("List: $list")
}