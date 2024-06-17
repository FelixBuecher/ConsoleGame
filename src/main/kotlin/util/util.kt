package util

/**
 * This file is used for timing functions, so I can beautify the game.
 *
 * @author Felix Bücher
 * @version 1.0
 */

fun smallSleep() = Thread.sleep(500)
fun medSleep() = Thread.sleep(2000)
fun bigSleep() = Thread.sleep(4000)

fun newBlock() {
    println()
    println()
    println()
    println()
    println()
    println()
    println()
    println()
    println()
    println()
    println()
    println()
}

fun calcDamageRange(attribute: Int, minBonus: Int, minScaling: Double, maxBonus: Int, maxScaling: Double): IntRange {
    return ((minBonus + attribute * minScaling).toInt()..(maxBonus + attribute * maxScaling).toInt())
}