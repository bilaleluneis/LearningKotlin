package basics

/**
 * @author Bilal El Uneis
 * @since Feb 2018
 * bilaleluneis@gmail.com
 */

class WithTest {
    fun methodOne() = println("methodOne called!")
    fun methodTwo() = println("methodTwo called!")
}

fun main(args: Array<String>) {

    val testWith = WithTest()

    /**
     * normally you would have to make the calls to methodOne and methodTwo
     * using testWith.methodOne(), etc .. but using with(){} you don't have to
     * makes it little cleaner
     */
    with(testWith){
        methodOne()
        methodTwo()
    }

}