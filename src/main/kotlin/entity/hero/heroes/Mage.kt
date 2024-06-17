package entity.hero.heroes


import effects.skill.skills.offensive.BasicAttack
import effects.skill.skills.offensive.Meteor
import entity.Bag
import entity.hero.Attribute
import entity.hero.Hero

class Mage(
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
        BasicAttack(),
        Meteor()
    ),
    bag
) {

}