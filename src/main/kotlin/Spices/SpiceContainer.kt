package Spices

data class SpiceContainer(val name: String){}

fun main(){

    makeSpiceContainers()
}

fun makeSpiceContainers() {

    val s1 = SpiceContainer("Curry")
    println(s1)

    val s2 = SpiceContainer("Red pepper")
    println(s2)
}
