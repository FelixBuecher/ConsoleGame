package effects.skill.skills.offensive

import S_SKILL_HEROIC_STRIKE
import S_SKILL_HEROIC_STRIKE_D
import effects.skill.SingleTargetSkill
import effects.skill.SkillType

/**
 * A stronger basic attack that does some extra damage but also has a small cooldown.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class HeroicStrike(
    effectRange: IntRange
) : SingleTargetSkill(
    S_SKILL_HEROIC_STRIKE,
    S_SKILL_HEROIC_STRIKE_D,
    (effectRange.min() + 10..effectRange.max() + 15),
    SkillType.OFFENSIVE,
    1,
    2
)