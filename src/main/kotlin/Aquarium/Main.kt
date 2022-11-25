package Aquarium

fun main(){
    buildAquarium()

    makeFish()

    delegateForTilapia()
}

internal fun buildAquarium() {
    val aquarium = Aquarium()

    println("Length: ${aquarium.length}  Width: ${aquarium.width} Height: ${aquarium.height}")

    aquarium.length = 80
    println("Length: ${aquarium.length}  Width: ${aquarium.width} Height: ${aquarium.height}")

    println("Volume: ${aquarium.volume}")

    val spice = SimpleSpice()
    println("Spice: ${spice.name} Heat: $spice ${spice.heat}")

    var smallAqualium = Aquarium(width = 15, height = 30, length = 20)
    println("Small aquarium: ${smallAqualium.volume} litres  ")

    val myAquarium = Aquarium(numberOfFish = 9)

    println("Small aquarium2 ${myAquarium.volume} litres with Length: ${myAquarium.length} Width: ${myAquarium.width} Height: ${myAquarium.height}")
}

fun feedFish(fish: FishAction){
    fish.eat()
}

fun delegate(){
    val pleco = Plecostomus()
    println("Pleco: ${pleco.color}")
    pleco.eat()
}

fun delegateForTilapia(){
    val tilapia = Tilapia()
    println("Tilapia: ${tilapia.color}")
    tilapia.eat()
}

fun makeFish(){
    val shark = Shark()
    val plecostomus = Plecostomus()
    println("Shark: ${shark.color} \nPlecostomus: ${plecostomus.color}")

    shark.eat()
    plecostomus.eat()
}