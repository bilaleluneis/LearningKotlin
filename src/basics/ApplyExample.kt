package basics

/**
 * @author Bilal El Uneis
 * @since Feb 2018
 * bilaleluneis@gmail.com
 */

class ApplyTest {
    fun methodOne() = println("methodOne called!")
    fun methodTwo() = println("methodTwo called!")
}

fun main(args: Array<String>) {

    /**
     * apply{} seems to allow you to combine the power of let{} and with{}
     * so you can execute block of code and call methods without having to use
     * instance name before method call.
     */
    ApplyTest().apply {
        methodOne()
        methodTwo()
    }

}