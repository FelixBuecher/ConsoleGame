package effects.skill.skills.offensive

import effects.skill.SingleTargetSkill
import effects.skill.SkillType
import entity.Entity
import util.S_SKILL_FROZEN_STRIKE
import util.S_SKILL_FROZEN_STRIKE_D
import util.calcDamageRange

/**
 * A strike that has a hybrid scaling for its damage calculation.
 * Should deal significant amount of damage.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class FrozenStrike : SingleTargetSkill(
    S_SKILL_FROZEN_STRIKE,
    S_SKILL_FROZEN_STRIKE_D,
    SkillType.OFFENSIVE,
    0,
    5
) {
    override fun calculateEffectRange(entity: Entity) {
        val strRange = calcDamageRange(entity.strength, 10, 1.0, 20, 2.0)
        val dexRange = calcDamageRange(entity.dexterity, 0, 0.5, 0, 1.0)
        val minimum = strRange.min() + dexRange.min()
        val maximum = strRange.max() + dexRange.max()
        effectRange = (minimum..maximum)
    }
}