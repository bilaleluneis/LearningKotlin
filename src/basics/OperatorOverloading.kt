package basics

/**
 * @author Bilal El Uneis
 * @since Dec 2, 2017
 * bilaleluneis@gmail.com
 */

// simple enum representing colors. did something similar with Swift
enum class Colors(val fromColor: Colors?, val andColor: Colors?){

    UNDEFINED(null,null),
    RED(UNDEFINED, UNDEFINED),
    BLUE(UNDEFINED, UNDEFINED),
    YELLOW(UNDEFINED, UNDEFINED),
    GREEN(fromColor = YELLOW, andColor = BLUE),
    ORANGE(fromColor = YELLOW, andColor = RED),
    BROWN(fromColor = BLUE, andColor = RED);


}

/**
 * I tried first to basics.add this function as part of companion Object in basics.Colors enum
 * but compiler didn't like that. so I had to take it out and create it
 * as and extension function to overload the + operator for the basics.Colors enum!
 */
operator fun Colors.plus(anotherColor: Colors) : Colors {

    val colorList = enumValues<Colors>()
    for(color in colorList){ // maybe could have done using forEach{}

        val color1 = color.fromColor
        val color2 = color.andColor
        if((this == color1 && anotherColor == color2) || (this == color2 && anotherColor == color1)){
            return color
        }

    }

    return Colors.UNDEFINED
}

fun main(args: Array<String>) {

    var whatIsTheColor = Colors.YELLOW + Colors.RED
    println("whatIstheColor = $whatIsTheColor")

    whatIsTheColor = Colors.RED + Colors.YELLOW
    println("whatIstheColor = $whatIsTheColor")


}