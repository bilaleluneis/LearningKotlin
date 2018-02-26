package stackOverflow

/**
 * @author Bilal El Uneis
 * @since Feb 2018
 * bilaleluneis@gmail.com
 * attempt answer to question
 * @link https://stackoverflow.com/questions/48976470/builder-syntax-for-collections-in-kotlin
 */


data class Label(var name: String = "no name", var prefWidth: Double = 0.0)

fun main(args: Array<String>) {

    /**
     * someone beat me to it.. but this is one way to apply builder patter to collection
     * but one thing I learned that I don't think I realized.. is that apply actually returns
     * so I can use that knowledge when I need to apply changes to collection and assign to variable
     */
    val labels = arrayOf(Label("A"),Label("B"),Label("C")).apply {
       forEach { it.prefWidth = 50.0 }
    }

    labels.forEach {
        println("label name : ${it.name} and prefWidth = ${it.prefWidth}")
    }
}