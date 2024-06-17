package entity.enemy

import effects.skill.Skill
import entity.Entity
import entity.hero.Attribute

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