package entity.hero

import S_BACKPACK_INDEX
import S_PLAYER_READY
import S_SKILL_LISTING
import S_VALID_SELECTION
import entity.Bag
import entity.Entity

/**
 * Class for the heroes in the game, they don't differ much from entities, except that they have a backpack.
 *
 * @property name the name of the hero.
 * @property maxHP the maximum health points that the hero can have.
 * @property baseATK the basic damage of a hero, used for skill damage calculation.
 * @property backpack the shared backpack of the heroes.
 *
 * @author Felix Bücher
 * @version 1.0
 */
abstract class Hero(
    name: String,
    maxHP: Int,
    baseATK: Int,
    val backpack: Bag
) : Entity(
    name,
    maxHP,
    baseATK
) {
    override fun selectAction(enemies: List<Entity>, allies: List<Entity>) {
        // User information which hero is ready
        println(S_PLAYER_READY(this))
        // List all skills + backpack if there are items inside.
        skills.forEachIndexed { index, skill ->
            println(S_SKILL_LISTING(index + 1, skill))
        }
        if (backpack.items.isNotEmpty()) println(S_BACKPACK_INDEX(skills.size + 1))
        try {
            // Get user input
            val input = readln().toInt() - 1
            // Open backpack if the user has items and selected it
            if (backpack.items.isNotEmpty() && input == skills.size) {
                backpack.open(this, enemies, allies)
                return
            }
            // Otherwise use the selected skill
            val skill = skills[input]
            if (skill.currentCooldown == 0) skill.use(this, enemies, allies) else throw Exception()
        } catch (e: Exception) {
            println(S_VALID_SELECTION)
            selectAction(enemies, allies)
        }
    }
}