package entity.hero

import effects.skill.Skill
import entity.Bag
import entity.Entity
import util.S_BACKPACK_INDEX
import util.S_PLAYER_READY
import util.S_SKILL_LISTING
import util.S_VALID_SELECTION

/**
 * Class for the heroes in the game, they don't differ much from entities, except that they have a backpack.
 *
 * @property name the name of the hero.
 * @property maxHP the maximum health points that the hero can have.
 * @property baseATK the basic damage of a hero, used for skill damage calculation.
 * @property bag the shared backpack of the heroes.
 *
 * @author Felix Bücher
 * @version 1.0
 */
abstract class Hero(
    name: String,
    bonusBaseHP: Int,
    strength: Int,
    dexterity: Int,
    intelligence: Int,
    mainAttribute: Attribute,
    skills: MutableList<Skill>,
    val bag: Bag,
) : Entity(
    name,
    bonusBaseHP,
    strength,
    dexterity,
    intelligence,
    mainAttribute,
    skills
) {
    override fun selectAction(enemies: List<Entity>, allies: List<Entity>) {
        println(S_PLAYER_READY(this))
        skills.forEachIndexed { index, skill -> println(S_SKILL_LISTING(index + 1, skill)) }
        if (bag.items.isNotEmpty()) println(S_BACKPACK_INDEX(skills.size + 1))
        try {
            val input = readln().toInt() - 1
            // Open backpack if the user has items and selected it
            if (bag.items.isNotEmpty() && input == skills.size) {
                bag.open(this, enemies, allies)
            } else {
                // Otherwise use the selected skill
                val skill = skills[input]
                if (skill.currentCooldown == 0) skill.use(this, enemies, allies) else throw Exception()
            }
        } catch (e: Exception) {
            println(S_VALID_SELECTION)
            selectAction(enemies, allies)
        }
    }
}