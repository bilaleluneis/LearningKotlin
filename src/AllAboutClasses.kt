/**
 * @author Bilal El Uneis
 * @since Nov 20, 2017
 * bilaleluneis@gmail.com
 */

class AllAboutClasses // this is actually a valid class def in Kotlin

class CantInheritMe{

    init {
        println("Instance of CantInheritMe created!")
    }

}

// bellow if uncommented will throw compile time error that CantInheritMe is final by default
// and thus can not be inherited !
/*
class TryToInherit : CantInheritMe() {

}*/


fun main(args: Array<String>) {

    val allAboutClasses = AllAboutClasses()
    val cantInheritMe = CantInheritMe()

}