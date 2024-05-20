package effects.skill.skills.defensive

import S_SKILL_HEALING_LIGHT
import S_SKILL_HEALING_LIGHT_D
import effects.skill.SingleTargetSkill
import effects.skill.SkillType

/**
 * A simple single target healing spell, will heal a small amount but has a very small cooldown.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class HealingLight(
    effectRange: IntRange
) : SingleTargetSkill(
    S_SKILL_HEALING_LIGHT,
    S_SKILL_HEALING_LIGHT_D,
    effectRange,
    SkillType.DEFENSIVE,
    0,
    2
)