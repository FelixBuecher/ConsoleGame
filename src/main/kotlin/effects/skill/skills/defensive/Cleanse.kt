package effects.skill.skills.defensive

import effects.skill.SingleTargetSkill
import effects.skill.SkillType
import effects.status.stati.Poison
import entity.Entity
import util.S_SKILL_CLEANSE
import util.S_SKILL_CLEANSE_D

/**
 * A spell to remove the status poison.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Cleanse : SingleTargetSkill(
    S_SKILL_CLEANSE,
    S_SKILL_CLEANSE_D,
    SkillType.DEFENSIVE,
    0,
    1,
    listOf(),
    listOf(Poison())
) {
    override fun calculateEffectRange(entity: Entity) {
        effectRange = 0..0
    }

    override fun use(user: Entity, enemies: List<Entity>, allies: List<Entity>) {
        super.use(user, enemies, allies)

    }
}