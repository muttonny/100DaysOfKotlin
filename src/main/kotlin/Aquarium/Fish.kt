package Aquarium

class Fish(val friendly : Boolean = true, volumeNeeded : Int){

    val size: Int

    init {
        println("this is the first init")
    }

    constructor() : this(true, 9){
        println("running secondary constructor")
    }

    init {
        if(friendly){
            size = volumeNeeded
        }else {
            size = volumeNeeded * 2
        }
    }

    init {
        println("constructed fish is of size $volumeNeeded final size $size")
    }

    init {
        println("this is the last init")
    }

    fun makeDefaultFish() = Fish(true, 50)

    fun fishExample(){
        val fish = Fish(true, 20)
        println("Is this fish friendly? It need volume ${fish.size}")
    }
}