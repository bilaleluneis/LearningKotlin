package basics

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
sealed class HttpResponse

// the bellow classes able to extend basics.Response because they are in same file
// also notice .. you shouldn't be able to extend the bellow classes in this file
// or the outside because they are not declared open .. so by default they are final !

class SuccessResponse(val jsonResponse: String) : HttpResponse()

class FailureResponse(val errorCode:Int, val errorMessage: String) : HttpResponse()


// uncomment bellow and see the error...

//class TryingToExtendFinalClass : basics.Success()

// this is nice example of returning either basics.Success or basics.Failure basics.Response
fun getResponse() : HttpResponse {

    val randomResponse = Random().nextInt(2) + 1
    return when(randomResponse){
        1 -> SuccessResponse(jsonResponse = "{value : 200}")
        else -> FailureResponse(errorCode = 500, errorMessage = "Internal Server Error!")
    }

}