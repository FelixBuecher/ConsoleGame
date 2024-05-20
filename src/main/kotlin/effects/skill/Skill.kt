package effects.skill

import effects.status.Status
import entity.Entity

/**
 * Base class for all skills that can be used by entities.
 *
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
abstract class Skill(
    val name: String,
    val description: String,
    var effectRange: IntRange,
    val skillType: SkillType,
    var currentCooldown: Int,
    val maxCooldown: Int,
    val extraEffect: Status?
) {
    /**
     * Function to use the skill on any entity, either offensively or defensively.
     *
     * @param user the user of the skill.
     * @param enemies the list of the enemy entities, will be used for offensive skills.
     * @param allies the list of the allied entities, will be used for defensive skills.
     */
    abstract fun use(user: Entity, enemies: List<Entity>, allies: List<Entity>)

    /**
     * Reduces the current cooldown of the skill each round, so it can be used again.
     */
    fun progressCD() {
        if (currentCooldown > 0) currentCooldown--
    }
}

/**
 * Enum class to handle all different skill types.
 * Need to be adjusted in the "when" clause in the use function from Skill.
 */
enum class SkillType {
    OFFENSIVE,
    DEFENSIVE
}