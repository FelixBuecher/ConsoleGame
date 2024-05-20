package game

import S_ENEMY_WIN
import S_HERO_WIN
import effects.skill.consumables.HealingPotion
import entity.Bag
import entity.enemy.Enemy
import entity.enemy.enemies.Boss
import entity.hero.Hero
import entity.hero.heroes.Assasin
import entity.hero.heroes.Healer
import entity.hero.heroes.Mage
import entity.hero.heroes.Warrior

/**
 * The game settings and loop are in this class.
 * Use the start method to start a game!
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Game {
    // Initialize the backpack
    private val bag = Bag(
        mutableMapOf(
            HealingPotion() to 3
        )
    )

    // Inizialize the heroes
    private val heroParty = mutableListOf<Hero>(
        Warrior("Felix", 250, 20, bag),
        Mage("Bobby", 150, 5, bag),
        Assasin("Dennis", 180, 25, bag),
        Healer("Lia", 150, 5, bag)
    )

    // Initialize the enemy party
    private val enemyParty = mutableListOf<Enemy>(
        Boss("Deine Mudda", 1000, 35)
    )

    /**
     * Function to start and play the game, the whole game loop is inside here.
     */
    fun start() {
        // As long as at least one unit in each party is alive, keep playing.
        while (heroParty.any() && enemyParty.any()) {
            // Let the heroes do their action in random order each round!
            heroParty.shuffled().forEach {
                // Let the hero do his round and remove enemies if they are killed
                it.progressRound(enemyParty, heroParty)
                enemyParty.removeAll { enemy -> enemy.isDead() }
            }
            // Same but now for enemies
            enemyParty.shuffled().forEach {
                it.progressRound(heroParty, enemyParty)
                heroParty.removeAll { hero -> hero.isDead() }
            }
        }
        // Print either winning or losing text.
        println(if (heroParty.isEmpty()) S_ENEMY_WIN else S_HERO_WIN(heroParty))
    }
}