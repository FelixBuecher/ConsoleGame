package effects.skill.skills.offensive

import effects.skill.AOESkill
import effects.skill.SkillType
import effects.status.stati.Poison
import entity.Entity
import util.S_SKILL_POISON_CLOUD
import util.S_SKILL_POISON_CLOUD_D
import util.calcDamageRange

/**
 * A weak AOE skill that applies the poison status effect.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class PoisonCloud : AOESkill(
    S_SKILL_POISON_CLOUD,
    S_SKILL_POISON_CLOUD_D,
    SkillType.OFFENSIVE,
    0,
    6,
    listOf(Poison())
) {
    override fun calculateEffectRange(entity: Entity) {
        effectRange = calcDamageRange(entity.intelligence, 10, 0.2, 20, 0.5)
    }
}