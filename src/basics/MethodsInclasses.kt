package basics

/**
 * @author Bilal El Uneis
 * @since Nov 26, 2017
 * bilaleluneis@gmail.com
 */

//note: if class doesn't extend another , by default it extends "Any" class
open class ClassA {

    //this method can't be overridden in subclasses, by default methods are final !
    fun cantOverride(){ println("basics.ClassA -> cantOverride()") }

    // to allow override of method in subClass need to declare it as open
    open fun canOverride(){ println("basics.ClassA -> canOverride()") }

}

open class ClassB : ClassA() {

    override fun canOverride() {
        println("basics.ClassB -> canOverride()")
    }

    //uncomment bellow to see error
    //override fun cantOverride(){}
}

open class ClassC : ClassB() {

    //any class extending basics.ClassC can't override this method anymore
    final override fun canOverride() {
       println("basics.ClassC -> canOverride()")
    }

}

class ClassD : ClassC() {

    //uncomment bellow line and you will see error
   // override fun canOverride(){}

}

fun main(args: Array<String>) {

    // the fact I can create the class instance, without assigning to variable is cool!

    // method Override Rules Examples
    ClassA().canOverride()
    ClassA().cantOverride()
    ClassB().canOverride()
    ClassC().canOverride()
    ClassD().canOverride()
    ClassD().cantOverride()

}