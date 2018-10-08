package intermediate

import java.util.*

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
 */
data class Point3D(private val x: Int, private val y: Int, private val z: Int) : Point2D(x, y) // Ex of Inheritance


data class Shape3D(val points: List<Point3D>) // Ex of Composition



fun main(args: Array<String>) {
    val points: List<Point3D> = Arrays.asList(Point3D(0, 0, 0), Point3D(0, 0, 0))
    Shape3D(points)
}