/**
 * @author Bilal El Uneis
 * @since Jan 1, 2018
 * bilaleluneis@gmail.com
 */


// this method returns Unit by default
fun failureOne(errorMessage: String) { throw Exception(errorMessage) }

// this method never returns as return type is Nothing
fun failureTwo(errorMessage: String): Nothing = throw Exception(errorMessage)

fun main(args: Array<String>) {

    val flag = true

    // this val is of type Any because it could get either an Int 42 or Unit and both are subclass of Any
    val firstTypeInfrenceTest = if(flag){ 42 } else { failureOne("failure One") }

    //this val is of type Int because it could get only Int 42 otherwise Nothing
    val secondTypeInfrenceTest = if(flag){ 42 } else { failureTwo("failure Two") }

}