package intermediate

import java.util.*

/**
 * @author Bilal El Uneis
 * @since Oct 2018
 * bilaleluneis@gmail.com
 */

/**
 * notice that you cant mark class as protected only public and private !
 * if you do protected open class Point2D you will get error (Modifier protected is not applicable inside file).
 * if you mark class as private , you wont be able to inherit from it.
 * so in order to make sure that no instance of this class can be created in main, but still can inherit it
 * I made the default constructor to be protected.
 */

 open class Point2D protected constructor(private val x: Int, private val y: Int) {
    init{
        println("new Point2D(${this.x}, ${this.y}) created!")
    }
}

/**
 * data class can inherit from open classes, but you can not inherit from data class,
 * because data class is final.
 * @sample InvokableClassWithLambda
 */
data class Point3D(private val x: Int, private val y: Int, private val z: Int) : Point2D(x, y) // Ex of Inheritance


open class Shape3D protected constructor(private val points: List<Point3D>){

    var listOfPoints: List<Point3D> = ArrayList(0)
        private set

    init{
        for (point in this.points) this.listOfPoints += point
    }

    open fun draw(){TODO("Must be overridden in Sub class!")}

}

/**
 * when making the class open, then you can inherit and can attempt to override draw() because it was open
 * in super class which I guess means it is open in subclass? to make sure that a subclass of Sphere can't override
 * the draw() just mark it as final and subclass wont be able to override it.
 */
open class Sphere (private val center: Point3D, private val circumference: Int): Shape3D(ArrayList(0)){

    final override fun draw(){
        for(point in this.listOfPoints){
            // do some drawing and apply algorithm to use center and circumference
           // if(this.center)
        }
    }
}


fun main(args: Array<String>) {
}