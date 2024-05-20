package effects.status.stati

import S_IS_BURN
import S_IS_NOT_BURN
import S_STATUS_BURN
import effects.status.Status
import entity.Entity
import newBlock
import smallSleep

/**
 * A status that deals some damage and does get removed on its own after some rounds.
 * Deals damage based on the entities maximum health.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Burn : Status(
    S_STATUS_BURN,
    2
) {
    override fun effect(target: Entity) {
        if (remainingDuration > 0) {
            val damage = (target.maxHP * 0.07).toInt()
            println(S_IS_BURN(target, remainingDuration, damage))
            remainingDuration--
        } else {
            println(S_IS_NOT_BURN(target.name))
        }
        newBlock()
        smallSleep()
    }
}