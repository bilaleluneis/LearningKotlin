package intermediate

/**
 * @author Bilal El Uneis
 * @since September 2018
 * bilaleluneis@gmail.com
 */


fun main(args: Array<String>) {

    // simple use of when statement
    val dayOfWeek = 3
    when(dayOfWeek){
        1 -> println("Monday")
        2 -> println("Tuesday")
        else -> { // using block to have multiple lines of code
            println("in Else Statement")
            println("Some other day of week in block code!")
        }
    }

    //using as expression
    val dayAsString = when(dayOfWeek){
        1    -> "Monday"
        else -> "Unknown"
    }
    println(dayAsString)

    //combining cases .. when is a more advanced switch
    val typeOfDay = when(dayOfWeek){
        1, 2     -> "week day!"
        in 3..5  -> "still week day!"
        !in 3..5 -> "might not be a week day!"
        else     -> "must be weekend!"
    }
    println(typeOfDay)

    //using when to determine Type
    val anything: Any = "Hi!"
    when(anything){
        is String -> println("$anything is a String")
        !is Int   -> println("$anything is not an int!")
    }

}