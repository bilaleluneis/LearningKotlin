package intermediate

/**
 * @author Bilal El Uneis
 * @since September 2018
 * bilaleluneis@gmail.com
 */

/**
 * by implementing the invoke() operator for a class, you
 * can call the class instance as if it was a method after
 * initialization.
 */
class InvokableClass(private val id: Int) {
    operator fun invoke() = println(id)
}


class InvokableClassWithLambda(private val lambda: (Int,Int) -> Int) {
    operator fun invoke(first: Int, second: Int): Int = this.lambda(first, second)
}


fun main(args: Array<String>) {

    val invokable = InvokableClass(2)
    invokable()

    val plusOperation = InvokableClassWithLambda {x,y -> x + y}
    print("result of 3 + 4 is ${plusOperation(3,4)}")

}