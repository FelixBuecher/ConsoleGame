package effects.skill.skills.offensive

import effects.skill.AOESkill
import effects.skill.SkillType
import effects.status.stati.Poison
import entity.Entity
import util.S_SKILL_METEOR
import util.S_SKILL_METEOR_D
import util.calcDamageRange

/**
 * A very strong AOE spell that does massive damage but has a high cooldown.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class PoisonCloud : AOESkill(
    S_SKILL_METEOR,
    S_SKILL_METEOR_D,
    SkillType.OFFENSIVE,
    0,
    6,
    listOf(Poison())
) {
    override fun calculateEffectRange(entity: Entity) {
        effectRange = calcDamageRange(entity.intelligence, 10, 0.2, 20, 0.5)
    }
}