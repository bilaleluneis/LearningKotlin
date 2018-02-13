package basics

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * @author Bilal El Uneis
 * @since Feb 2018
 * bilaleluneis@gmail.com
 */

class PropertyObserverExample {

    var counterA : Int by Delegates.observable(initialValue = 0){
        // used _ for property and oldValue as I don't care for those
        _, _, newValue ->
        if(newValue == 3){ counterA = 0 }
    }

    // another way to doing the above
    var counterB : Int by Delegates.observable(0, ::propertyDelegate)

    private fun propertyDelegate(property: KProperty<*>, oldValue: Int, newValue: Int) {
        if(newValue == 2){ counterB = 0 }
    }

}


fun main(args: Array<String>) {

    val propObserverExample = PropertyObserverExample()

    for (i in 0..10) {
        println("counterA++ = ${propObserverExample.counterA++}")
        println("counterB++ = ${propObserverExample.counterB++}")
    }

}