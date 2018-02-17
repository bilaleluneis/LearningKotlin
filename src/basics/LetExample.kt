package basics

/**
 * @author Bilal El Uneis
 * @since Feb 2018
 * bilaleluneis@gmail.com
 */

fun main(args: Array<String>) {

    var stringValue : String? = "Hello"

    /**
     * example of using let after testing if optional is not null
     * if not null then let block will execute
     */
    stringValue?.let{ println("name is $it !") }

}