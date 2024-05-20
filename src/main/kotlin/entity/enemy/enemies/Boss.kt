package entity.enemy.enemies

import entity.Entity
import entity.enemy.Enemy

class Boss(
    name: String,
    maxHP: Int,
    baseATK: Int,
) : Enemy(
    name,
    maxHP,
    baseATK
) {

    override fun recalcSkills() {
    }

    override fun selectAction(enemies: List<Entity>, allies: List<Entity>) {
        
    }
}