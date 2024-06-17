package effects.skill.skills.defensive

import effects.skill.SingleTargetSkill
import effects.skill.SkillType
import effects.status.stati.Strong
import entity.Entity
import util.S_SKILL_POWER_UP
import util.S_SKILL_POWER_UP_D

/**
 * A simple single target healing spell, will heal a small amount but has a very small cooldown.
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
    Strong()
) {
    override fun calculateEffectRange(entity: Entity) {
        effectRange = 0..0
    }
}