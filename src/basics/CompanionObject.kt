package basics

/**
 * @author Bilal El Uneis
 * @since Jan 7, 2018
 * bilaleluneis@gmail.com
 */

class ClassWithCompanionObject {

    constructor() {
        numberOfInstancesOfClass++
        println("create instance number $numberOfInstancesOfClass of ClassWithCompanionObject")
    }

    /**
     * companion Object is a singleton object
     * so only one instance of it is created..
     * similar to Java Static block .. Kotlin doesn't
     * have static. so everything inside a companion
     * object can be thought of as static and will be
     * initialized only once.
     */
    companion object {

        private var numberOfInstancesOfClass = 0

        fun printNumberOfInstancesOfClassValue(){
            println("numberOfInstancesOfClass = $numberOfInstancesOfClass !")
        }
    }
}

fun main(args: Array<String>) {

    ClassWithCompanionObject()
    ClassWithCompanionObject()
    ClassWithCompanionObject()
    ClassWithCompanionObject.printNumberOfInstancesOfClassValue()

}