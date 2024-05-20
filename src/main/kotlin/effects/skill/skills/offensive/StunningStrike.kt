package effects.skill.skills.offensive

import S_SKILL_STUNNING_STRIKE
import S_SKILL_STUNNING_STRIKE_D
import effects.skill.SingleTargetSkill
import effects.skill.SkillType
import effects.status.stati.Stun

/**
 * A skill that does low damage, but also applies the stun status.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class StunningStrike(
    effectRange: IntRange
) : SingleTargetSkill(
    S_SKILL_STUNNING_STRIKE,
    S_SKILL_STUNNING_STRIKE_D,
    effectRange,
    SkillType.OFFENSIVE,
    2,
    4,
    Stun()
)