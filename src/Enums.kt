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
        // to call the method bellow you -> DayOfTheWeek.dayFromNumber()
        // I guess it is treated as class level method instead of instance method
        // or maybe as static method!
        fun dayFromNumber(number: Int) : DayOfTheWeek = DayOfTheWeek.values().first{ x-> x.dayNumber == number }
    }

    // this is an instance method, that can be called only on an instance of the enum
    fun nextDay() : DayOfTheWeek {
       return dayFromNumber(this.dayNumber + 1)
    }

}

/**
 * In one of the IOS course by Paul Hegarty from Stanford University, I saw this cool code snippet
 * to build a calculator logic where Enum was used to associate operator with operation
 * I want to try and see how to do that with Kotlin Enum.
 */
enum class SimpleMathOperations(val operator: String, val operation: (Int,Int) -> Int){

    ADD("+", {x,y -> x + y}),
    SUBTRACT("-", {x,y -> x - y})

}


fun main(args: Array<String>) {

    //simple example of enum
    val adayOfTheWeek = DayOfTheWeek.MONDAY
    val numberValueOfDayOfTheWeek = adayOfTheWeek.dayNumber
    println("${adayOfTheWeek.name} is number $numberValueOfDayOfTheWeek")

    val dayOfTheWeek : DayOfTheWeek = DayOfTheWeek.dayFromNumber(3)
    println("dayOfTheWeek = $dayOfTheWeek")

    val today = DayOfTheWeek.MONDAY
    val tomorrow = today.nextDay()
    println("Today is $today and Tomorrow is $tomorrow")

    //This should be cool :)
    val operator = SimpleMathOperations.ADD.operator
    val operation = SimpleMathOperations.ADD.operation
    println("2 $operator 3 = ${operation(2,3)}") //very cool !

}