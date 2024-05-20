package effects.skill.consumables

import S_ITEM_HEALING_POTION
import S_ITEM_HEALING_POTION_D
import effects.skill.SingleTargetSkill
import effects.skill.SkillType

/**
 * A simple single target healing potion, will heal a small amount.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class HealingPotion : SingleTargetSkill(
    S_ITEM_HEALING_POTION,
    S_ITEM_HEALING_POTION_D,
    45..55,
    SkillType.DEFENSIVE,
    0,
    0
)