package effects.skill

import effects.status.Status
import entity.Entity
import util.*

/**
 * Base class for all AOE (Area of effect) skills.
 * Can be used for buffs, attacks or even heals.
 * @property skillName the name of the skill.
 * @property description a short description about what the skill does.
 * @property skillType the type of the skill, so far there are only offensive and defensive skills.
 * @property currentCooldown the initial and current cooldown of a skill.
 * @property maxCooldown the max cooldown of a skill, can be 0 for skills that can be used each round.
 * @property extraEffects if the skill can apply extra status effects it is to be added here.
 * @property extraEffectRemove if the skill can remove status effects it is to be added here.
 *
 * @author Felix Bücher
 * @version 1.0
 */
abstract class AOESkill(
    name: String,
    description: String,
    skillType: SkillType,
    currentCooldown: Int = 0,
    maxCooldown: Int = 0,
    extraEffects: List<Status> = listOf(),
    extraEffectsRemove: List<Status> = listOf(),
) : Skill(
    name,
    description,
    skillType,
    currentCooldown,
    maxCooldown,
    extraEffects,
    extraEffectsRemove
) {
    override fun use(user: Entity, enemies: List<Entity>, allies: List<Entity>) {
        newBlock()
        // Check whether to use the skill on enemies or allies
        val targets = when (skillType) {
            SkillType.OFFENSIVE -> enemies
            SkillType.DEFENSIVE -> allies
        }

        // No need for target selection -> can handle enemy and hero the same
        println(S_USE_SKILL(user, skillName))
        targets.forEach { target ->
            println()
            // Get the damage or healing and apply it + status effects
            val effect = when (skillType) {
                SkillType.OFFENSIVE -> (effectRange.random() * user.damageModifier).toInt()
                SkillType.DEFENSIVE -> -effectRange.random()
            }
            target.getAttacked(effect)
            extraEffects.forEach { status ->
                status.factory().apply(target)
            }
            extraEffectRemove.forEach { status ->
                targets.forEach { entity ->
                    entity.removeStatus(status)
                }
            }

            // Show info to the user, how the skill affected the game
            when (skillType) {
                SkillType.OFFENSIVE -> println(S_SKILLHIT(target, skillName, effect))
                SkillType.DEFENSIVE -> println(S_SKILLHEAL(target, skillName, effect))
            }
            smallSleep()
        }
        // Put skill on cooldown
        currentCooldown = maxCooldown
        println()
    }
}