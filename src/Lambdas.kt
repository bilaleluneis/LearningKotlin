/**
 * @author Bilal El Uneis
 * @since Nov 27, 2017
 * bilaleluneis@gmail.com
 */


// this is a function that takes 2 integers and a function .. and returns an integer
fun executeOperation(firstInt: Int, secondInt: Int, operation: (Int,Int) -> Int) : Int {

    val result = operation(firstInt,secondInt)
    return result
}

//simple function tht adds two values
fun add(value1: Int, value2: Int) : Int {

    return value1 + value2

}


fun main(args: Array<String>) {

    val rangeOfNumbers = 1..100
    /**
     * filter is a function that takes another function as parameter
     * you can either pass another function or just write the function
     * body
     * @see Collection.filter
     */

    val resultOfLambdaCallFilter = rangeOfNumbers.filter{ x -> x in 25..50 }
    println("$resultOfLambdaCallFilter")

    //another way to write the above
    val anotherResultOfLambdaCallFilter = rangeOfNumbers.filter { it in 90..100 }
    println("$anotherResultOfLambdaCallFilter")

    //example using the executeOperation()
    var addOperationResult = executeOperation(2,3, operation = ::add)
    println("addOperationResult = $addOperationResult")

    //same as above but with assign to val .. functions are first class objects
    val addOperation : (Int,Int) -> Int = ::add // could have used type inference , but wanted to be verbose
    addOperationResult = executeOperation(4,6, addOperation)
    println("addOperationResult = $addOperationResult")

}