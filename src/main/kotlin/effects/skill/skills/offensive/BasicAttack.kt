package effects.skill.skills.offensive

import util.S_SKILL_BASIC_ATTACK
import util.S_SKILL_BASIC_ATTACK_D
import util.calcDamageRange
import effects.skill.SingleTargetSkill
import effects.skill.SkillType
import entity.Entity
import entity.hero.Attribute

/**
 * The basic attack of every entity, each unit shall have it, so they can always at least do one action.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class BasicAttack : SingleTargetSkill(
    S_SKILL_BASIC_ATTACK,
    S_SKILL_BASIC_ATTACK_D,
    SkillType.OFFENSIVE
) {
    override fun calculateEffectRange(entity: Entity) {
        effectRange = when (entity.mainAttribute) {
            Attribute.STRENGTH -> calcDamageRange(entity.strength, 9, 0.9, 11, 1.1)
            Attribute.DEXTERITY -> calcDamageRange(entity.dexterity, 7, 0.7, 17, 1.7)
            Attribute.INTELLIGENCE -> calcDamageRange(entity.intelligence, 2, 0.2, 4, 0.4)
        }
    }
}