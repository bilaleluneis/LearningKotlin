package basics.Classes

/**
 * @author Bilal El Uneis
 * @since Jan 7, 2018
 * bilaleluneis@gmail.com
 */

// this a valid class that can't be extended .. by default classes are marked final
class SimpleAndFinal

// use open keyword to allow extending classes
open class SimpleAndExtendable

//sub class that also can be extended
open class SubClass : SimpleAndExtendable()

// sealed classes are open only inside this file, from the outside they are final
sealed class Response
class Success : Response() // final and can not be extended
open class Failure : Response() // can be extended



fun main(args: Array<String>) {

    //examples of how instances are created .. no new keyword in Kotlin
    SimpleAndFinal()
    SubClass()

    //bellow is valid because Success and Failure are SubType of Response
    val responseObjectList : Array<Response> = arrayOf(Success(),Failure())

    for(response in responseObjectList){
        when(response){ // when is more powerful form of if or switch
            is Success -> println("Response of Type Success pulled from Array!")
            is Failure -> println("Response of Type Failure pulled from Array!")
        }
    }

}