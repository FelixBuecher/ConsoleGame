package effects.skill.skills.offensive

import effects.skill.AOESkill
import effects.skill.SkillType
import effects.status.stati.Burn
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
class Meteor : AOESkill(
    S_SKILL_METEOR,
    S_SKILL_METEOR_D,
    SkillType.OFFENSIVE,
    2,
    6,
    Burn()
) {
    override fun calculateEffectRange(entity: Entity) {
        effectRange = calcDamageRange(entity.intelligence, 10, 1.5, 30, 2.5)
    }
}