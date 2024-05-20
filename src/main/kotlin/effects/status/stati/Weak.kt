package effects.status.stati

import S_IS_NOT_WEAK
import S_IS_WEAK
import S_STATUS_WEAK
import effects.status.Status
import entity.Entity
import newBlock
import smallSleep

/**
 * A status that reduces the base damage of an entity by 50%.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Weak : Status(
    S_STATUS_WEAK,
    3
) {
    override fun apply(target: Entity) {
        super.apply(target)
        target.currentATK = (target.baseATK * 0.5).toInt()
        target.recalcSkills()
    }

    override fun effect(target: Entity) {
        if (remainingDuration > 0) {
            println(S_IS_WEAK(target.name, remainingDuration))
            remainingDuration--
        } else {
            println(S_IS_NOT_WEAK(target.name))
            target.currentATK = target.baseATK
            target.recalcSkills()
        }
        newBlock()
        smallSleep()
    }
}