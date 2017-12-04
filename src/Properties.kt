import kotlin.reflect.KProperty

/**
 * @author Bilal El Uneis
 * @since Dec 3, 2017
 * bilaleluneis@gmail.com
 */

class PersonInfo{

    /**
     * example of delegating set and get for a property.. what is
     * interesting and I didn't realize until i started playing with this
     * that the line by PersonFirstNameDelegate() will create new instance
     * of that class that is dedicated to the PersonInfo Instance using it.
     */
    var firstName: String by PersonFirstNameDelegate(this)
    var lastName: String = ""

}

/**
 * to expose the fact that a new instance of this is created and dedicated
 * to the instance of PersonInfo using it, I added reference to that class
 * in the public constructor and also did println() in the init to see it.
 */
class PersonFirstNameDelegate(val personInfo: PersonInfo) {

    private var firstNameValue = ""

    init{
       println("Inatializing new PersonFirstNameDelegate for $personInfo")
    }

    //tried to use KProperty<String> .. but compiler didn't like it
    operator fun getValue(thisRef: PersonInfo, property: KProperty<*>) : String {

        return firstNameValue

    }

    operator fun setValue(thisRef: PersonInfo, property: KProperty<*>, propertyValue: String){

        if(propertyValue.equals("Bilal",true)){
            println("Found you! in $thisRef now assigning your last name for you!")
            thisRef.lastName = "El Uneis"
            firstNameValue = propertyValue
        }

    }
}

fun main(args: Array<String>) {

    val person = PersonInfo()
    person.firstName = "Bilal"
    println("${person.firstName} ${person.lastName}")

}

