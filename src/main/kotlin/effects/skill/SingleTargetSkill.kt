package effects.skill

import effects.status.Status
import entity.Entity
import entity.hero.Hero
import util.*

/**
 * Base class for all single target skills.
 * Can be used for buffs, attacks or even heals.
 * @param skillName the name of the skill.
 * @param description a short description about what the skill does.
 * @param skillType the type of the skill, so far there are only offensive and defensive skills.
 * @param currentCooldown the initial and current cooldown of a skill.
 * @param maxCooldown the max cooldown of a skill, can be 0 for skills that can be used each round.
 * @param extraEffect if the skill can apply an extra status effect it is to be added here.
 *
 * @author Felix Bücher
 * @version 1.0
 */
abstract class SingleTargetSkill(
    skillName: String,
    description: String,
    skillType: SkillType,
    currentCooldown: Int = 0,
    maxCooldown: Int = 0,
    extraEffects: List<Status> = listOf(),
    extraEffectsRemove: List<Status> = listOf(),
) : Skill(
    skillName,
    description,
    skillType,
    currentCooldown,
    maxCooldown,
    extraEffects,
    extraEffectsRemove
) {

    override fun use(user: Entity, enemies: List<Entity>, allies: List<Entity>) {
        newBlock()
        // Selection whether to use enemies or allies as targets.
        val targets = when (skillType) {
            SkillType.OFFENSIVE -> enemies
            SkillType.DEFENSIVE -> allies
        }
        try {
            val target: Entity
            if (user is Hero) {
                // Human interaction
                println(S_SELECT_TARGET)
                targets.forEachIndexed { index, entity -> println(S_SKILL_TARGET_SELECTION(index, entity)) }
                println(S_CANCEL_INDEX(targets.size))

                val input = readln().toInt() - 1
                if (input == targets.size) {
                    user.selectAction(enemies, allies)
                    return
                }
                target = targets[input]
            } else {
                // Enemy logic goes here
                target = targets.random()
            }

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
                target.removeStatus(status)
            }

            // Put skill on cooldown
            currentCooldown = maxCooldown

            // Show info to the user, how the skill affected the game
            println(S_USE_SKILL(user, skillName))
            when (skillType) {
                SkillType.OFFENSIVE -> println(S_SKILLHIT(target, skillName, effect))
                SkillType.DEFENSIVE -> println(S_SKILLHEAL(target, skillName, effect))
            }
            smallSleep()
            println()
        } catch (e: Exception) {
            println(S_VALID_SELECTION)
            use(user, enemies, allies)
        }
    }

}