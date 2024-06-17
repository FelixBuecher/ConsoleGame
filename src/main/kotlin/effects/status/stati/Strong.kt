package effects.status.stati

import effects.status.Status
import entity.Entity
import util.*

/**
 * A status that increases the damage of an entity by 30%.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Strong : Status(
    S_STATUS_STRONG,
    3,
    ::Strong
) {
    override fun apply(target: Entity) {
        super.apply(target)
        target.damageModifier *= 1.3
    }

    override fun effect(target: Entity) {
        if (remainingDuration > 0) {
            println(S_IS_STRONG(target.name, remainingDuration))
            remainingDuration--
        } else {
            println(S_IS_NOT_STRONG(target.name))
            target.damageModifier /= 1.3
        }
        medSleep()
        newBlock()
    }
}