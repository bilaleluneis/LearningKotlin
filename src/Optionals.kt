/**
 * @author Bilal El Uneis
 * @since Nov 29, 2017
 * bilaleluneis@gmail.com
 */

data class Address(val street: String? = null, val city: String?, val state: String?)

data class Person(val firstName:String, val middleInitial: String? = null, val lastName: String, val address: Address?)

/**
 * and infix extension function on Person Type
 * to learn more about extension and infix functions
 * @see String.isEmpty and
 * @see Int.multiplyBy
 */
infix fun Person.livesIn(address:Address?) : Boolean {


    if(address != null && this.address != null){

        val leftSideStreet = this.address.street ?: ""
        val rightSideStreet = address.street ?: ""
        val isSameStreet = leftSideStreet.equals(rightSideStreet, ignoreCase = false)

        val leftSideCity = this.address.city ?: ""
        val rightSideCity = address.city ?: ""
        val isSameCity = leftSideCity.equals(rightSideCity, ignoreCase = false)

        val leftSideState = this.address.state ?: ""
        val rightSideState = address.state ?: ""
        val isSameState = leftSideState.equals(rightSideState, ignoreCase = false)

        return isSameStreet && isSameCity && isSameState

    }

    return false
}

infix fun Person.doesntLiveIn(address:Address?) : Boolean {

    //the proper way to do this.. but will comment out , as I want to try the !! operator
    //val liveInSameAddress = this.livesIn(address)
    //return !liveInSameAddress

    val addressesNotNull = address != null && this.address != null

    if(addressesNotNull){

        val leftSideStreet = this.address?.street ?: "" //had to use address? to test optional is not null
        val rightSideStreet = address?.street ?: ""
        val isSameStreet = leftSideStreet.equals(rightSideStreet, ignoreCase = false)

        val leftSideCity = this.address?.city ?: ""
        val rightSideCity = address?.city ?: ""
        val isSameCity = leftSideCity.equals(rightSideCity, ignoreCase = false)

        val leftSideState = this.address!!.state ?: "" //used !! to force un-wrap as I know address is not null
        val rightSideState = address!!.state ?: ""
        val isSameState = leftSideState.equals(rightSideState, ignoreCase = false)

        return !(isSameStreet && isSameCity && isSameState)

    }

    return false

}

/**
 * example using the let function to deal with null items
 * @see let
 */
fun returnNonNulItemlList(aList: List<String?>) : List<String> {

    var result = listOf<String>()

    for(item in aList){
        item?.let{result = result.plus(it)}
        //or can be called like this too .. item?.let{result = result.plus(item)}
    }

    return result
}

fun main(args: Array<String>) {

    val name: String? = null // change to actual value to see the println() change
    /**
     * notice the ?: called Elvis operator bellow, if name is not null , name will be returned
     * if name is null then the string "Empty" will be returned
     */
    println("name is ${name?:"Empty"}") //notice ?: operator

    val rooster = Person("Bilal", lastName = "El Uneis", address = Address(city = "Atlanta", state = "GA"))
    val kitty = Person("Cat", lastName = "BMW", address = Address(city = "Atlanta", state = "GA"))

    if(rooster livesIn kitty.address){
        println("Both Rooster and Kitty live together!")
    }else if(rooster doesntLiveIn kitty.address){
        println("Rooster and Kitty don't live together!")
    }

    //example using let function to deal with null values
    val nonNullList = returnNonNulItemlList(listOf("Bilal","Kitty",null,"BMW"))
    println("nonNullList contains: $nonNullList")

}