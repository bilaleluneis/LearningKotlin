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

    // simple init array with elements
    var arrayOfStrings : Array<String> = arrayOf("One","Two","Three")

    // takes a closure where i is an index
    val arrayOfInts = Array(5,{i -> i + 1})

    //another way to write the above, as closer is last argument
    val anotherarrayOfInts = Array(5){ i-> i+1 }

    //lazy is a function that takes another function, again the closure is last argument
    val lazyArray by lazy { lazyArrayInit() } // you could write your own function inside.

    private fun lazyArrayInit() : Array<Int> {
        println("Lazy Init called!")
        return arrayOf(1,2,3,4,5)
    }



}

fun main(args: Array<String>) {

    val array = ArrayOperations()
    array.arrayOfStrings += "Four" // += operator overloaded to add new element to array

    println("${Arrays.toString(array.arrayOfStrings)}")
    println("${Arrays.toString(array.arrayOfInts)}")

}