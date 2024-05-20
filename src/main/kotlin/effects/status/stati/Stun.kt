package effects.status.stati

import S_IS_NOT_STUNNED
import S_IS_STUNNED
import S_STATUS_STUN
import effects.status.Status
import entity.Entity
import newBlock
import smallSleep

/**
 * A status that does prevent an entity from takin an action during their round.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Stun : Status(
    S_STATUS_STUN,
    2
) {
    override fun effect(target: Entity) {
        if (remainingDuration > 0) {
            println(S_IS_STUNNED(target.name, remainingDuration))
            remainingDuration--
        } else {
            println(S_IS_NOT_STUNNED(target.name))
        }
        newBlock()
        smallSleep()
    }
}