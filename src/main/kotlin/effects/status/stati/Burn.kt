package effects.status.stati

import util.S_IS_BURN
import util.S_IS_NOT_BURN
import util.S_STATUS_BURN
import effects.status.Status
import entity.Entity
import util.medSleep
import util.newBlock

/**
 * A status that deals some damage and does get removed on its own after some rounds.
 * Deals damage based on the entities maximum health.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Burn : Status(
    S_STATUS_BURN,
    2,
    ::Burn
) {
    override fun effect(target: Entity) {
        if (remainingDuration > 0) {
            val damage = (target.maxHP * 0.07).toInt()
            println(S_IS_BURN(target, remainingDuration, damage))
            remainingDuration--
        } else {
            println(S_IS_NOT_BURN(target.name))
        }
        medSleep()
        newBlock()
    }
}