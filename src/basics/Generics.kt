package basics

/**
 * @author Bilal El Uneis
 * @since Dec 19, 2017
 * bilaleluneis@gmail.com
 */

/**
 * this is interesting!
 * because I put private for genericValue, I cant do .genericValue
 * when I create an instance
 */
class SimpleGenericClass<T> (private val genericValue: T)

//out keyword allows an instance of this to be assigned to its supertype but not subType
class CanBeAssignedToSuperType<out T>

//in allows an instance to be assigned to SubType but not Super Type
class CanBeAssignedToSubType<in T>


fun main(args: Array<String>) {

    val genericVal = SimpleGenericClass(1)

    /**
     * Number is SuperType of Double because Double extends Number
     * @see Number
     * @see Double
     */
    val superTypeOfDouble: CanBeAssignedToSuperType<Number> = CanBeAssignedToSuperType<Double>()
    val subTypeOfNumber: CanBeAssignedToSubType<Double> = CanBeAssignedToSubType<Number>()


}