package entity

import S_CANCLE_INDEX
import S_ITEM_LISTING
import S_OPEN_BACKPACK
import S_VALID_SELECTION
import effects.skill.Skill
import newBlock

/**
 * A backpack that is to be shared between heroes.
 * Can hold some "items" that are basically skills with a limited use count.
 *
 * @property items the map of items to count, the key is the item/skill and the value is the amount left.#
 *
 * @author Felix Bücher
 * @version 1.0
 */
class Bag(
    val items: MutableMap<Skill, Int>
) {
    fun open(user: Entity, enemies: List<Entity>, allies: List<Entity>) {
        // Print backpack information
        newBlock()
        println(S_OPEN_BACKPACK(user))
        // Convert map to list of pairs, so we can have indices and list items + cancel
        val itemPairList = items.toList()
        itemPairList.forEachIndexed { index, itemPair ->
            println(S_ITEM_LISTING(index + 1, itemPair.first, itemPair.second))
        }
        println(S_CANCLE_INDEX(items.size + 1))
        try {
            // Get userinput
            val input = readln().toInt() - 1
            // User input cancel
            if (input == items.size) {
                user.selectAction(enemies, allies)
                return
            }
            val itemPair = itemPairList[input]
            val skill = itemPair.first
            val count = itemPair.second
            // If the item has uses left use it
            if (count > 0) skill.use(user, enemies, allies) else throw Exception()
            // If the item is depleted after using, remove it.
            if (count - 1 == 0) items.remove(skill) else items[skill] = count - 1
        } catch (e: Exception) {
            println(S_VALID_SELECTION)
            open(user, enemies, allies)
        }
    }
}