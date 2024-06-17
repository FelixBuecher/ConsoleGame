package entity.enemy.enemies

import effects.skill.skills.offensive.BasicAttack
import effects.skill.skills.offensive.Meteor
import entity.Entity
import entity.enemy.Enemy
import entity.hero.Attribute

class Boss(
    name: String,
    maxHP: Int,
    strength: Int,
    dexterity: Int,
    intelligence: Int,
    mainAttribute: Attribute,
) : Enemy(
    name,
    maxHP,
    strength,
    dexterity,
    intelligence,
    mainAttribute,
    mutableListOf(
        BasicAttack(),
        Meteor()
    )
) {
    override fun selectAction(enemies: List<Entity>, allies: List<Entity>) {
        skills.filter { it.currentCooldown == 0 }.random().use(this, enemies, allies)
    }
}
