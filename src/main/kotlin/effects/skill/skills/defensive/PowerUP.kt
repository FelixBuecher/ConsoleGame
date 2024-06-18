package effects.skill.skills.defensive

import effects.skill.SingleTargetSkill
import effects.skill.SkillType
import effects.status.stati.Strong
import entity.Entity
import util.S_SKILL_POWER_UP
import util.S_SKILL_POWER_UP_D

/**
 * A spell that adds the status strong, which increases the damage an entity deals.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class PowerUP : SingleTargetSkill(
    S_SKILL_POWER_UP,
    S_SKILL_POWER_UP_D,
    SkillType.DEFENSIVE,
    0,
    5,
    listOf(Strong())
) {
    override fun calculateEffectRange(entity: Entity) {
        effectRange = 0..0
    }
}