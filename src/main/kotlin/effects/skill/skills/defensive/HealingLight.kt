package effects.skill.skills.defensive

import effects.skill.SingleTargetSkill
import effects.skill.SkillType
import entity.Entity
import util.S_SKILL_HEALING_LIGHT
import util.S_SKILL_HEALING_LIGHT_D
import util.calcDamageRange

/**
 * A simple single target healing spell, will heal a small amount but has a very small cooldown.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class HealingLight : SingleTargetSkill(
    S_SKILL_HEALING_LIGHT,
    S_SKILL_HEALING_LIGHT_D,
    SkillType.DEFENSIVE,
    0,
    2
) {
    override fun calculateEffectRange(entity: Entity) {
        effectRange = calcDamageRange(entity.intelligence, 20, 1.0, 40, 1.0)
    }
}