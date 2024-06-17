package effects.skill.skills.offensive

import effects.skill.SingleTargetSkill
import effects.skill.SkillType
import entity.Entity
import util.S_SKILL_HEROIC_STRIKE
import util.S_SKILL_HEROIC_STRIKE_D
import util.calcDamageRange

/**
 * A stronger basic attack that does some extra damage but also has a small cooldown.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class HeroicStrike : SingleTargetSkill(
    S_SKILL_HEROIC_STRIKE,
    S_SKILL_HEROIC_STRIKE_D,
    SkillType.OFFENSIVE,
    1,
    2
) {
    override fun calculateEffectRange(entity: Entity) {
        effectRange = calcDamageRange(entity.strength, 10, 1.0, 25, 1.0)
    }
}