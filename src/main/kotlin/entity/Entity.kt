package entity

import effects.skill.Skill
import effects.status.Status
import effects.status.stati.Stun

/**
 * An entity in this game, can be an enemy or an ally.
 * Makes it easier to write generally applicable functions.
 *
 * @property name the name of the entity.
 * @property maxHP the maximum possible HP that the entity can have.
 * @property baseATK the base bonus ATK that should be added to skills.
 *
 * @author Felix Bücher
 * @version 1.0
 */
abstract class Entity(
    val name: String,
    var maxHP: Int,
    var baseATK: Int,
) {
    // Set current = max when creating a unit
    var currentHP: Int = maxHP
    var currentATK: Int = baseATK
    var skills: MutableList<Skill> = mutableListOf()
    var currentStatus: MutableList<Status> = mutableListOf()

    init {
        this.recalcSkills()
    }

    /**
     * Reduce the life of an entity.
     *
     * @param damage the damage dealt to the entity.
     */
    fun getAttacked(damage: Int) {
        currentHP -= damage
        if (currentHP > maxHP) currentHP = maxHP
        if (currentHP < 0) currentHP = 0
    }

    /**
     * Will be called each round once for every entity.
     * Progresses status effects etc.
     *
     * @param enemies the targets that the entity can choose from.
     * @param allies the allies the entity can choose from.
     */
    open fun progressRound(enemies: List<Entity>, allies: List<Entity>) {
        // If there are no enemies left skip turn to progress faster to victory.
        if (enemies.isEmpty()) return
        // Activate all status effects and apply them on the entity
        currentStatus.forEach { status ->
            status.effect(this)
        }
        // If the entity is stunned prevent it from acting
        val isStunned = currentStatus.any { status ->
            status is Stun
        }
        // Remove the stun status when the duration is over
        currentStatus.removeAll {
            it.remainingDuration <= 0
        }
        if (isStunned) return
        // Progress all skill cooldowns if the entity is not stunned
        skills.forEach { skill ->
            skill.progressCD()
        }
        // Let the entity select its action
        selectAction(enemies, allies)
    }

    /**
     * Check if an entity is alive or not.
     * @return entity is alive.
     */
    fun isDead(): Boolean {
        return currentHP <= 0
    }

    /**
     * Adds a status effect to the entity.
     *
     * @param status the status effect to add.
     */
    fun addStatus(status: Status) {
        currentStatus.add(status)
    }

    /**
     * Removes a status effect from the entity.
     *
     * @param status the status effect to remove.
     */
    fun removeStatus(status: Status) {
        currentStatus.remove(status)
    }

    /**
     * Recalculate the skill damage for all skills for an entity.
     * Needs to be called if an entity gets the status WEAK or STRONG!
     */
    abstract fun recalcSkills()

    /**
     * Handle the userinput for the specified entity.
     * In case of NPC entities the behaviour logic goes here.
     *
     * @param enemies the targets that the entity can choose from.
     * @param allies the allies the entity can choose from.
     */
    abstract fun selectAction(enemies: List<Entity>, allies: List<Entity>)
}