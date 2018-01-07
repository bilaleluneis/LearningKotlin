package basics

/**
 * @author Bilal El Uneis
 * @since Dec 5, 2017
 * bilaleluneis@gmail.com
 */

/**
 * Any custom Exception is child of Throwable
 * @see Throwable
 */
class MyException(val exceptionMessage: String) : Throwable()

// can accept null , but will throw exception
fun example1(param: String?) : String  { // notice , unlike Java the method is not marked () throws Exception
    return param ?: throw MyException(exceptionMessage = "param is null in basics.example1()")
}

fun main(args: Array<String>) {

    println(example1("Hello!"))

    //try is an expression , so you can assign result to variable
    val resultOfCall = try{

        example1("Hi") // change to pass in null, to see how the catch returns

    }catch(exception: MyException){ // the body can have logic and at the end the value to assign to variable

        println("Error Caught! result of Call will = null was passed!")
        "null was passed!"

    }finally{ // will always be called at the end
        println("executing Finally block!")
    }

    /**
     * look at the console and see the sequence of events here.
     * first the try is executed, if success then, the finally is executed
     * if not, then catch is executed , then finally and at the end
     * the assignment of value to resultOfCall
     */
    println(resultOfCall)

}