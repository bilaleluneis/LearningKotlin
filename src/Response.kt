import java.util.*

/**
 * @author Bilal El Uneis
 * @since Nov 25, 2017
 * bilaleluneis@gmail.com
 */

/* example of Sealed class in Kotlin
You can only extend the class inside this file and it is treated as closed
from outside this file... I learned about this and the example from a Kotlin
talk on YouTube by Hadi Hariri
*/
sealed class Response

// the bellow classes able to extend Response because they are in same file
// also notice .. you shouldn't be able to extend the bellow classes in this file
// or the outside because they are not declared open .. so by default they are final !

class Success(val jsonResponse: String) : Response()

class Failure(val errorCode:Int, val errorMessage: String) : Response()


// uncomment bellow and see the error...

//class TryingToExtendFinalClass : Success()

// this is nice example of returning either Success or Failure Response
fun getResponse() : Response {

    val randomResponse = Random().nextInt(2) + 1
    return when(randomResponse){
        1 -> Success(jsonResponse = "{value : 200}")
        else -> Failure(errorCode = 500 , errorMessage = "Internal Server Error!")
    }

}