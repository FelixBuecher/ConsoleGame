package effects.status.stati

import S_IS_NOT_STRONG
import S_IS_STRONG
import S_STATUS_STRONG
import effects.status.Status
import entity.Entity
import newBlock
import smallSleep

/**
 * A status that increases the base damage of an entity by 50%.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Strong : Status(
    S_STATUS_STRONG,
    3
) {
    override fun apply(target: Entity) {
        super.apply(target)
        target.currentATK = (target.baseATK * 1.5).toInt()
        target.recalcSkills()
    }

    override fun effect(target: Entity) {
        if (remainingDuration > 0) {
            println(S_IS_STRONG(target.name, remainingDuration))
            remainingDuration--
        } else {
            println(S_IS_NOT_STRONG(target.name))
            target.currentATK = target.baseATK
            target.recalcSkills()
        }
        newBlock()
        smallSleep()
    }
}