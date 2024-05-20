package entity.hero.heroes

import effects.skill.skills.offensive.BasicAttack
import entity.Bag
import entity.hero.Hero

class Assasin(
    name: String,
    maxHP: Int,
    baseATK: Int,
    bag: Bag
) : Hero(
    name,
    maxHP,
    baseATK,
    bag
) {
    override fun recalcSkills() {
        skills = mutableListOf(
            BasicAttack(currentATK..currentATK * 2),
        )
    }
}