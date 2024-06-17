package effects.status.stati

import effects.status.Status
import entity.Entity
import util.*

/**
 * A status that reduces the damage of an entity by 30%.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Weak : Status(
    S_STATUS_WEAK,
    3,
    ::Weak
) {
    override fun apply(target: Entity) {
        super.apply(target)
        target.damageModifier *= 0.7
    }

    override fun effect(target: Entity) {
        if (remainingDuration > 0) {
            println(S_IS_WEAK(target.name, remainingDuration))
            remainingDuration--
        } else {
            println(S_IS_NOT_WEAK(target.name))
            target.damageModifier /= 0.7
        }
        medSleep()
        newBlock()
    }
}