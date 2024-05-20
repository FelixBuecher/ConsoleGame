package entity.hero.heroes

import effects.skill.skills.offensive.BasicAttack
import effects.skill.skills.offensive.Meteor
import entity.Bag
import entity.hero.Hero

class Mage(
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
            Meteor(40..80)
        )
    }
}