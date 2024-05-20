package effects.skill

import S_SKILLHEAL
import S_SKILLHIT
import S_VALID_SELECTION
import effects.status.Status
import entity.Entity
import newBlock
import smallSleep

/**
 * Base class for all AOE (Area of effect) skills.
 * Can be used for buffs, attacks or even heals.
 * @property name the name of the skill.
 * @property description a short description about what the skill does.
 * @property effectRange heal or damage of a skill, the final effect will be a random number in the range.
 * @property skillType the type of the skill, so far there are only offensive and defensive skills.
 * @property currentCooldown the initial and current cooldown of a skill.
 * @property maxCooldown the max cooldown of a skill, can be 0 for skills that can be used each round.
 * @property extraEffect if the skill can apply an extra status effect it is to be added here.
 *
 * @author Felix Bücher
 * @version 1.0
 */
abstract class AOESkill(
    name: String,
    description: String,
    effectRange: IntRange,
    skillType: SkillType,
    currentCooldown: Int = 0,
    maxCooldown: Int = 0,
    extraEffect: Status? = null,
) : Skill(
    name,
    description,
    effectRange,
    skillType,
    currentCooldown,
    maxCooldown,
    extraEffect
) {
    override fun use(user: Entity, enemies: List<Entity>, allies: List<Entity>) {
        try {
            newBlock()
            // Check whether to use the skill on enemies or allies
            val targets = when (skillType) {
                SkillType.OFFENSIVE -> enemies
                SkillType.DEFENSIVE -> allies
            }
            // No need for target selection -> can handle enemy and hero the same
            targets.forEach { target ->
                println()
                // Get the damage or healing and apply it + status effects
                val effect = when (skillType) {
                    SkillType.OFFENSIVE -> effectRange.random()
                    SkillType.DEFENSIVE -> -effectRange.random()
                }
                target.getAttacked(effect)
                extraEffect?.apply(target)

                // Show info to the user, how the skill affected the game
                val stringToPrint = when (skillType) {
                    SkillType.OFFENSIVE -> S_SKILLHIT(target, name, effect)
                    SkillType.DEFENSIVE -> S_SKILLHEAL(target, name, effect)
                }
                println(stringToPrint)
                smallSleep()
            }
            // Put skill on cooldown
            currentCooldown = maxCooldown
            println()
        } catch (e: Exception) {
            println(S_VALID_SELECTION)
            use(user, enemies, allies)
        }
    }
}