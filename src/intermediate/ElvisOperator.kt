package intermediate

/**
 * @author Bilal El Uneis
 * @since Oct 2018
 * bilaleluneis@gmail.com
 */

fun main(args: Array<String>) {

    val test: String? = "Hello"

    /**
     *  ?: operator basically says, if the expression on the left is null then
     *  use / return/ execute the expression on the right instead.
     */
    test?.let{ println("String is $it") } ?: println("Empty")
}