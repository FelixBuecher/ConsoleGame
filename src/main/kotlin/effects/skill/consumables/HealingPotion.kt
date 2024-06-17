package effects.skill.consumables

import effects.skill.SingleTargetSkill
import effects.skill.SkillType
import entity.Entity
import util.S_ITEM_HEALING_POTION
import util.S_ITEM_HEALING_POTION_D

/**
 * A simple single target healing potion, will heal a small amount.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class HealingPotion : SingleTargetSkill(
    S_ITEM_HEALING_POTION,
    S_ITEM_HEALING_POTION_D,
    SkillType.DEFENSIVE,
    0,
    0
) {
    init {
        effectRange = 45..55
    }

    override fun calculateEffectRange(entity: Entity) {
        effectRange = 45..55
    }
}