package effects.status.stati

import effects.status.Status
import entity.Entity
import util.S_IS_POISON
import util.S_STATUS_POISON
import util.medSleep
import util.newBlock

/**
 * A status that deals some damage and does not get removed on its own, unless a certain spell or item is used.
 * Deals damage based on the entities maximum health.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Poison : Status(
    S_STATUS_POISON,
    1,
    ::Poison
) {
    override fun effect(target: Entity) {
        val damage = (target.maxHP * 0.04).toInt()
        target.getAttacked(damage)
        println(S_IS_POISON(target, damage))
        medSleep()
        newBlock()
    }
}