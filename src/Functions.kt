/**
 * @author Bilal El Uneis
 * @since Nov 23, 2017
 * bilaleluneis@gmail.com
 */

// simple function that will return String .. i guess this is like inline functions in C / C++
fun printHello() = "Hello World!"

// function syntax, with default values, this allow the creation
// of scalable and overloaded functions instead of having to create new
// function each time with new arguments

fun addOnlyPositive(firstValue: Int =0 , secondValue: Int =0) : Int {

    if(firstValue > 0 && secondValue > 0) {
        return firstValue + secondValue
    }

    return 0

}

//interesting example I saw in Kotlin talk on YouTube by Venkat Subramaniam
fun greet(name: String, message: String ="Hi ${name.length}") {
    println("$message $name")
}

//varargs example: one or more arguments function
fun averageOf(vararg numbers: Int) : Int {

    var result = 0
    for( number in numbers){
        result += number
    }
    return result / numbers.size
}

//extension functions ... a nice way to add features on a type without having to subtype or extend it
/*fun String.isEmpty() : Boolean {

    if(this.length == 0 || this.trim().length == 0) return true
    return false

}*/
//another nice way to write the above extension function
fun String.isEmpty() = when(this.trim().length) {
    0 -> true
    else -> false
}

fun main(args: Array<String>) {

    val functionValue = printHello()
    println(functionValue)

    //example of what could be overloaded function in language like Java !
    addOnlyPositive(firstValue = 1)
    addOnlyPositive(secondValue = 2)
    addOnlyPositive(firstValue = 5, secondValue = 3)
    addOnlyPositive(secondValue = 2, firstValue = 2) //you can change the order of params .. very cool
    addOnlyPositive()
    greet(name="Rooster")
    greet("Kitty") //this is also valid way to call without using name

    //varargs examples
    println("Average is : ${averageOf(1,2,3,4,5,6,7,8,9,10)}")

    //extension functions
    println("is '' empty? ${"".isEmpty()}")
    println("is 'Meawer' empty? ${"Meawer".isEmpty()}")

}