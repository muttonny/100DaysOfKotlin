object MobyDickWhale {
    val author = "mut tony"

    fun jump(){
        //..
    }
}

enum class Color2(val rgb: Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00)
}

sealed class Seal

class SeaLion: Seal()

class Walrus: Seal()

fun matchSeal(seal: Seal): String{
    return when (seal){
        is SeaLion -> "seal lion"
        is Walrus -> "walrus"
    }
}