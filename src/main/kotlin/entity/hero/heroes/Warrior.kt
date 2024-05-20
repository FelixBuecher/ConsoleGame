package entity.hero.heroes

import effects.skill.skills.offensive.BasicAttack
import effects.skill.skills.offensive.HeroicStrike
import effects.skill.skills.offensive.StunningStrike
import entity.Bag
import entity.hero.Hero

class Warrior(
    name: String,
    maxHP: Int,
    baseATK: Int,
    bag: Bag
) : Hero(
    name,
    maxHP,
    baseATK,
    bag,
) {
    override fun recalcSkills() {
        skills = mutableListOf(
            BasicAttack(currentATK..(currentATK * 1.5).toInt()),
            HeroicStrike(currentATK..(currentATK * 2)),
            StunningStrike(0..5)
        )
    }
}

