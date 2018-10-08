package basics


/**
 * @author Bilal El Uneis
 * @since Oct 2018
 * bilaleluneis@gmail.com
 */

fun main(args: Array<String>) {

    // create array of Int of size 5 and each element initialized to 0
    var arrayOfIntegers = Array(5) { _ -> 0}  // could write as Array(5, { _ -> 0}) too!
    println(arrayOfIntegers.size)
    arrayOfIntegers += 1
    println(arrayOfIntegers.size)

}

