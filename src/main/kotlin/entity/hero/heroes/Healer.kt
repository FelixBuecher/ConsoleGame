package entity.hero.heroes

import effects.skill.skills.defensive.HealingLight
import effects.skill.skills.offensive.BasicAttack
import entity.Bag
import entity.hero.Hero

class Healer(
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
            BasicAttack(currentATK..currentATK),
            HealingLight(30..50)
        )
    }
}