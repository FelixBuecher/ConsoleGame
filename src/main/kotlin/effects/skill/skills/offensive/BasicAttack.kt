package effects.skill.skills.offensive

import S_SKILL_BASIC_ATTACK
import S_SKILL_BASIC_ATTACK_D
import effects.skill.SingleTargetSkill
import effects.skill.SkillType

/**
 * The basic attack of every entity, each unit shall have it, so they can always at least do one action.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class BasicAttack(
    effectRange: IntRange
): SingleTargetSkill(
    S_SKILL_BASIC_ATTACK,
    S_SKILL_BASIC_ATTACK_D,
    effectRange,
    SkillType.OFFENSIVE
)