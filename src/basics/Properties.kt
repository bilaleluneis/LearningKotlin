package basics

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
     * that the line by basics.PersonFirstNameDelegate() will create new instance
     * of that class that is dedicated to the basics.PersonInfo Instance using it.
     */
    var firstName: String by PersonFirstNameDelegate(this)

    /**
     * bellow means that homeAdress will be initialized later, so we don't have to initialize here or in init(){}
     * it seems that you can only use lateinit with var and not val
     */
    lateinit var homeAdress: String private set // made the setter private to force use update(address:){}

    //bellow will get initialized only when accessed for first time.. and will only be initialized once
    val listOfAddressesLivedIn by lazy{ generateListOfAddresses() }

    //simple property that is initialized in init(){}
    var lastName: String

    /**
     * this is a get only property .. I also believe this is
     * a computed property!
     */
    val fullName: String get(){ return "$firstName $lastName"}

    // default initializer .. notice didn't need to init fullName nor firstName!
    init{

        lastName = ""

    }

    fun update(address: String){
        homeAdress = address
    }

    private fun generateListOfAddresses(): Array<String> = arrayOf("200 live street" , "900 hover dam")

}

/**
 * to expose the fact that a new instance of this is created and dedicated
 * to the instance of basics.PersonInfo using it, I added reference to that class
 * in the public constructor and also did println() in the init to see it.
 */
class PersonFirstNameDelegate(val personInfo: PersonInfo) {

    private var firstNameValue = ""

    init{
       println("Inatializing new basics.PersonFirstNameDelegate for $personInfo")
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
    person.update(address = "100 king street")
    println("${person.firstName} ${person.lastName}")
    println("${person.fullName}")
    //person.fullName = "" // if you uncomment this it will error out!
    println("${person.homeAdress}")
    println("${person.listOfAddressesLivedIn}")

}

