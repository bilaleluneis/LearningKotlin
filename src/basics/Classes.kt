package basics

/**
 * @author Bilal El Uneis
 * @since Nov 20, 2017
 * bilaleluneis@gmail.com
 */


/**
 * NOTES:
 * - by default a class is final and cant be extended.
 * - by default a class is public.
 * - cant create protected class inside a file!!!
 */

class AllAboutClasses // this is actually a valid class def in Kotlin

class CantInheritMe{

    init {
        println("Instance of basics.CantInheritMe created!")
    }

}

// bellow if uncommented will throw compile time error that basics.CantInheritMe is final by default
// and thus can not be inherited !
/*
class TryToInherit : basics.CantInheritMe() {

}*/

open class Base  // this class is open and can be extended

class ChildA : Base()

//public class that is final with private default constructor and public secondary constructor
class ClassWithPrivateDefaultConstructor private constructor(){

     private var _instanceName: String? =  null
    /**
     * bellow is val and can only be initialized once
     * and can only be initialized inside init{}
     */
     private val _privateInstanceName: String

    /**
     * bellow is property that has public get and private set
     */
    var privateSetProperty: Int private set

    //this is secondary constructor that can be used and is default to public access
    constructor(instanceName: String) : this() {
        _instanceName = instanceName
        println("new Instance of basics.ClassWithPrivateDefaultConstructor with name $instanceName")
    }

    // this init is private because i declared default constructor as private
    init{
        println("basics.ClassWithPrivateDefaultConstructor private init called!")
        _privateInstanceName = "only initialized in private Constructor"
        privateSetProperty = 0
    }

}

//bellow will error out if uncommented , because basics.Response was declared Sealed
//class Unseal : basics.Response()


fun main(args: Array<String>) {

    val allAboutClasses = AllAboutClasses()
    val cantInheritMe = CantInheritMe()
    val childA : Base = ChildA() //childA is constant of type basics.Base assigned to instance of basics.ChildA()
    val privateConstructorObject = ClassWithPrivateDefaultConstructor("duh")

    /** example of method that could return object that is of type basics.Success or basics.Failure
     *  @see Response
     *  @see Success
     *  @see Failure
     */
    val response = getResponse()
    when(response){
        is SuccessResponse -> println("basics.Success basics.Response returned ${response.jsonResponse}")
        is FailureResponse -> println("basics.Failure basics.Response returned ${response.errorCode}")
    }

}