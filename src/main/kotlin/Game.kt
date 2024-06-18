import effects.skill.consumables.HealingPotion
import entity.Bag
import entity.enemy.Enemy
import entity.enemy.enemies.Boss
import entity.hero.Attribute
import entity.hero.Hero
import entity.hero.heroes.Assasin
import entity.hero.heroes.Mage
import entity.hero.heroes.Priest
import entity.hero.heroes.Warrior
import util.S_ENEMY_WIN
import util.S_HERO_WIN
import util.S_ROUND

/**
 * The game settings and loop are in this class.
 * Use the start method to start a game!
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Game {
    /**
     * Function to start and play the game, the whole game loop is inside here.
     */
    fun start() {
        // Initialize the backpack
        val bag = Bag(
            mutableMapOf(
                HealingPotion() to 3
            )
        )

        // Inizialize the heroes
        val heroParty = mutableListOf<Hero>(
            Warrior("Felix", 90, 25, 10, 5, Attribute.STRENGTH, bag),
            Mage("Bobby", 120, 5, 10, 35, Attribute.INTELLIGENCE, bag),
            Assasin("Dennis", 70, 10, 30, 10, Attribute.DEXTERITY, bag),
            Priest("Lia", 120, 5, 15, 25, Attribute.INTELLIGENCE, bag)
        )

        // Initialize the enemy party
        val enemyParty = mutableListOf<Enemy>(
            Boss("Lich King", 1000, 60, 35, 20, Attribute.STRENGTH)
        )

        var roundCounter = 0

        // As long as at least one unit in each party is alive, keep playing.
        while (heroParty.any() && enemyParty.any()) {
            roundCounter++
            println(S_ROUND(roundCounter))
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