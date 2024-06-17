package entity.hero.heroes

import effects.skill.skills.offensive.BasicAttack
import entity.Bag
import entity.hero.Attribute
import entity.hero.Hero

class Assasin(
    name: String,
    bonusBaseHP: Int,
    strength: Int,
    dexterity: Int,
    intelligence: Int,
    mainAttribute: Attribute,
    bag: Bag,
) : Hero(
    name,
    bonusBaseHP,
    strength,
    dexterity,
    intelligence,
    mainAttribute,
    mutableListOf(
        BasicAttack()
    ),
    bag
) {

}