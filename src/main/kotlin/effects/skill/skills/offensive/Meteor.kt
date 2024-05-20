package effects.skill.skills.offensive

import S_SKILL_METEOR
import S_SKILL_METEOR_D
import effects.skill.AOESkill
import effects.skill.SkillType
import effects.status.stati.Burn

/**
 * A very strong AOE spell that does massive damage but has a high cooldown.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Meteor(
    effectRange: IntRange
) : AOESkill(
    S_SKILL_METEOR,
    S_SKILL_METEOR_D,
    effectRange,
    SkillType.OFFENSIVE,
    2,
    6,
    Burn()
)