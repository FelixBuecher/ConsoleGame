package effects.status

import entity.Entity

/**
 * Status is a passive condition that an entity can have.
 * They get applied once with the apply function and effect the entity each round with the effect function.
 *
 * @property name the name of the status.
 * @property remainingDuration any status with a remaining duration of 0 will get removed from an entity
 * once it is their turn. The duration does not decrease on its own.
 * So if you want to have a status effect that does not get removed on its own,
 * set its duration to above 1 and never decrease it, only when the condition you want is met.
 *
 * @author Felix Bücher
 * @version 1.0
 */
abstract class Status(
    val name: String,
    var remainingDuration: Int,
    val classType: () -> Status
) {

    /**
     * Apply the status once, will check if the entity had the status before and will override it.
     * To be able to stack status you can simply disable the remove.
     *
     * @param target the entity to add the status to.
     */
    open fun apply(target: Entity) {
        target.currentStatus.removeIf { status ->
            status.name == this.name
        }
        target.addStatus(this)
    }

    /**
     * Gets called every round to apply the effect of the status on the entity.
     *
     * @param target the entity to affect.
     */
    abstract fun effect(target: Entity)

    /**
     * Used to create a new instance of a status, very important for AOE skills,
     * otherwise all hit entities would have the same status that shares its duration etc.
     * @return the new instance of the desired status.
     */
    fun factory(): Status {
        return classType()
    }
}