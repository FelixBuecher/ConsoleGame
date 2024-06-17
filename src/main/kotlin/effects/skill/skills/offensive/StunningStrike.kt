package effects.skill.skills.offensive

import effects.skill.SingleTargetSkill
import effects.skill.SkillType
import effects.status.stati.Stun
import entity.Entity
import util.S_SKILL_STUNNING_STRIKE
import util.S_SKILL_STUNNING_STRIKE_D
import util.calcDamageRange

/**
 * A skill that does low damage, but also applies the stun status.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class StunningStrike : SingleTargetSkill(
    S_SKILL_STUNNING_STRIKE,
    S_SKILL_STUNNING_STRIKE_D,
    SkillType.OFFENSIVE,
    2,
    4,
    Stun()
) {
    override fun calculateEffectRange(entity: Entity) {
        effectRange = calcDamageRange(entity.strength, 2, 0.6, 5, 1.0)
    }
}