package entity.enemy

import effects.skill.Skill
import entity.Entity
import entity.hero.Attribute

/**
 * Class for the enemies in the game, they don't differ much from entities, yet.
 * TODO need to implement special attribute for enemies
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
abstract class Enemy(
    name: String,
    bonusBaseHP: Int,
    strength: Int,
    dexterity: Int,
    intelligence: Int,
    mainAttribute: Attribute,
    skills: MutableList<Skill>,
) : Entity(
    name,
    bonusBaseHP,
    strength,
    dexterity,
    intelligence,
    mainAttribute,
    skills,
)