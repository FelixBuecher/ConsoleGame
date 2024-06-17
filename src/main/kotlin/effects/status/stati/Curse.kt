package effects.status.stati

import effects.status.Status
import entity.Entity
import util.*

/**
 * A status that deals some damage and is removed once a unit falls under a certain life threshold.
 * Deals damage based on the entities current life.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Curse : Status(
    S_STATUS_CURSE,
    1,
    ::Curse
) {
    override fun effect(target: Entity) {
        if (target.currentHP > target.maxHP / 2) {
            val damage = (target.currentHP * 0.1).toInt()
            if (damage == 0) {
                println(S_IS_NOT_CURSE(target.name))
                remainingDuration = 0
            } else {
                println(S_IS_CURSE(target, damage))
            }
        } else {
            println(S_IS_NOT_CURSE(target.name))
            remainingDuration = 0
        }
        medSleep()
        newBlock()
    }
}