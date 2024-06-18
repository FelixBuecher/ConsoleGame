package entity.enemy.enemies

import effects.skill.skills.offensive.BasicAttack
import effects.skill.skills.offensive.FrozenStrike
import effects.skill.skills.offensive.PoisonCloud
import entity.Entity
import entity.enemy.Enemy
import entity.hero.Attribute


/**
 * Class for the boss in the game.
 *
 * @property name the name of the enemy.
 * @param bonusBaseHP the extra base life a unit shall have.
 * @property strength strength of the unit.
 * @property dexterity dexterity of the unit.
 * @property intelligence intelligence of the unit.
 * @property mainAttribute the main attribute of the unit, used for several scaling.
 * @property skills the list of skills that the unit has.
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Boss(
    name: String,
    bonusBaseHP: Int,
    strength: Int,
    dexterity: Int,
    intelligence: Int,
    mainAttribute: Attribute,
) : Enemy(
    name,
    bonusBaseHP,
    strength,
    dexterity,
    intelligence,
    mainAttribute,
    mutableListOf(
        BasicAttack(),
        FrozenStrike(),
        PoisonCloud()
    )
) {
    override fun selectAction(enemies: List<Entity>, allies: List<Entity>) {
        skills.filter { it.currentCooldown == 0 }.random().use(this, enemies, allies)
    }
}
