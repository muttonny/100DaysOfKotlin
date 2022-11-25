package Spices

import Color2

sealed class Spice (open val name: String, open val spiciness: String = "mild") : SpiceColor{

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

    abstract fun prepareSpice()

}

interface SpiceColor {
    val color: Color2
}

interface Grinder{

    fun grind(){
        println("Grinding spice")
    }
}
class Curry(override val name: String, spiciness: String) : Spice(name, spiciness), Grinder{

    override fun prepareSpice() {
        println("Preparing the Curry spice")
    }

    override val color: Color2
        get() = Color2.YELLOW

}

object YellowSpiceColor : SpiceColor{
    override val color: Color2
        get() = Color2.YELLOW

}

fun delegate(){
    val curry = Curry(name = "Curry", spiciness = "mild")
    println("${curry.name}: ${curry.color}")
}

fun main(){

    delegate()
}