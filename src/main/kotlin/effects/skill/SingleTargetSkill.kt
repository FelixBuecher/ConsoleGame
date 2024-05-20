package effects.skill

import S_CANCLE_INDEX
import S_ENEMY_ATTACK
import S_SELECT_TARGET
import S_SKILLHEAL
import S_SKILLHIT
import S_SKILL_TARGET_SELECTION
import S_VALID_SELECTION
import effects.status.Status
import entity.Entity
import entity.hero.Hero
import newBlock
import smallSleep

/**
 * Base class for all single target skills.
 * Can be used for buffs, attacks or even heals.
 * @param name the name of the skill.
 * @param description a short description about what the skill does.
 * @param effectRange heal or damage of a skill, the final effect will be a random number in the range.
 * @param skillType the type of the skill, so far there are only offensive and defensive skills.
 * @param currentCooldown the initial and current cooldown of a skill.
 * @param maxCooldown the max cooldown of a skill, can be 0 for skills that can be used each round.
 * @param extraEffect if the skill can apply an extra status effect it is to be added here.
 *
 * @author Felix Bücher
 * @version 1.0
 */
abstract class SingleTargetSkill(
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
            // Selection whether to use enemies or allies as targets.
            val targets = when (skillType) {
                SkillType.OFFENSIVE -> enemies
                SkillType.DEFENSIVE -> allies
            }
            val target: Entity

            newBlock()
            if (user is Hero) {
                // Human interaction
                // Simple print all possible options
                println(S_SELECT_TARGET)
                targets.forEachIndexed { index, entity ->
                    println(S_SKILL_TARGET_SELECTION(index, entity))
                }
                println(S_CANCLE_INDEX(targets.size + 1))
                println()

                val input = readln().toInt() - 1
                // User input cancel
                if (input == targets.size) {
                    user.selectAction(enemies, allies)
                    return
                }
                target = targets[input]
            } else {
                // Enemy logic goes here
                target = targets.random()
                println(S_ENEMY_ATTACK(user, name))
            }
            // Get the damage or healing and apply it + status effects
            val effect = when (skillType) {
                SkillType.OFFENSIVE -> effectRange.random()
                SkillType.DEFENSIVE -> -effectRange.random()
            }
            target.getAttacked(effect)
            extraEffect?.apply(target)
            // Put skill on cooldown
            currentCooldown = maxCooldown

            // Show info to the user, how the skill affected the game
            val stringToPrint = when (skillType) {
                SkillType.OFFENSIVE -> S_SKILLHIT(target, name, effect)
                SkillType.DEFENSIVE -> S_SKILLHEAL(target, name, effect)
            }
            println(stringToPrint)
            smallSleep()
            println()
        } catch (e: Exception) {
            println(S_VALID_SELECTION)
            use(user, enemies, allies)
        }
    }
}