package effects.status.stati

import S_IS_POISON
import S_STATUS_POISON
import effects.status.Status
import entity.Entity
import newBlock
import smallSleep

/**
 * A status that deals some damage and does not get removed on its own, unless a certain spell or item is used.
 * Deals damage based on the entities maximum health.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Poison : Status(
    S_STATUS_POISON,
    1
) {
    override fun effect(target: Entity) {
        val damage = (target.maxHP * 0.04).toInt()
        target.getAttacked(damage)
        println(S_IS_POISON(target, damage))
        newBlock()
        smallSleep()
    }
}