import java.util.*

/**
 * @author Bilal El Uneis
 * @since DEC 12, 2017
 * bilaleluneis@gmail.com
 */

/**
 * Demonstrate various operations on Arrays like
 * initialization
 * late initialization
 * inserting
 * getting
 */

class ArrayOperations{

    var arrayOfStrings : Array<String>

    init{
        arrayOfStrings = arrayOf("1","2","3")
    }
}

fun main(args: Array<String>) {

    val array = ArrayOperations()
    array.arrayOfStrings += "4" // += operator overloaded to add new element to array
    println("${Arrays.toString(array.arrayOfStrings)}") //[1, 2, 3, 4]

}