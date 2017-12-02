/**
 * @author Bilal El Uneis
 * @since Dec 1, 2017
 * bilaleluneis@gmail.com
 */


//simple enum declaration in Kotlin
enum class DayOfTheWeek(val dayNumber: Int){

    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    //you can add companion object .. i am guessing this is like anonymous class
    companion object{
        fun dayFromNumber(number: Int) : DayOfTheWeek = DayOfTheWeek.values().first{ x-> x.dayNumber == number }
    }


}

/**
 * In one of the IOS courses by Stanford University, I saw this cool code snippet
 * to build a calculator logic where Enum was used to associate operator with operation
 * I want to try and see how to do that with Kotlin Enum.
 */
enum class SimpleMathOperations(val operator: String, val operation: (Int,Int) -> Int){

    ADD("+", {x,y -> x + y}),
    MINUS("-", {x,y -> x - y})

}


fun main(args: Array<String>) {

    //simple example of enum
    val adayOfTheWeek = DayOfTheWeek.MONDAY
    val numberValueOfDayOfTheWeek = adayOfTheWeek.dayNumber
    println("${adayOfTheWeek.name} is number $numberValueOfDayOfTheWeek")

    val dayOfTheWeek : DayOfTheWeek = DayOfTheWeek.dayFromNumber(3)
    println("dayOfTheWeek = $dayOfTheWeek")

    //This should be cool :)
    val operator = SimpleMathOperations.ADD.operator
    val operation = SimpleMathOperations.ADD.operation
    println("2 $operator 3 = ${operation(2,3)}") //very cool !

}