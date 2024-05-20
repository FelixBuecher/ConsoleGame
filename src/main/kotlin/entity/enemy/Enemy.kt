package entity.enemy

import entity.Entity

abstract class Enemy(
    name: String,
    maxHP: Int,
    baseATK: Int
) : Entity(
    name,
    maxHP,
    baseATK
)