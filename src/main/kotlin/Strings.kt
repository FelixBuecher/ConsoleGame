import effects.skill.Skill
import entity.Entity

/**
 * This file has all the strings that are used in the game, function in here are stylized as constants,
 * since they are somewhat used in a similar fashion.
 *
 * @author Felix Bücher
 * @version 1.0
 */
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////  Color strings   //////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
const val RED = "\u001b[31m"
const val BLUE = "\u001b[34m"
const val YELLOW = "\u001b[33m"
const val GREEN = "\u001b[32m"
const val MAGENTA = "\u001b[35m"
const val CYAN = "\u001b[36m"
const val RESET = "\u001b[0m"

////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////  General strings   ////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
const val S_SELECT_TARGET = "Bitte wähle ein Ziel:"
const val S_VALID_SELECTION = "${RED}Bitte gib etwas valides ein!$RESET"
const val S_ENEMY_WIN = "Leider haben die Helden den Kampf verloren!"
const val S_BACKPACK = "Rucksack"

fun S_OPEN_BACKPACK(user: Entity) = "${name(user.name)} hat den Rucksack geöffnet und hat folgende Auswahl:"
fun S_BACKPACK_INDEX(index: Int) = "$index. ${skill("$S_BACKPACK öffnen")}"
fun S_CANCLE_INDEX(index: Int) = "$index. ${RED}Abbrechen$RESET"
fun S_PLAYER_READY(entity: Entity) = "${name(entity.name)} ist am Zug ${hp(entity)}, wähle deine Aktion aus:"
fun S_ENEMY_ATTACK(user: Entity, skillName: String) = "${name(user.name)} benutzt ${skill(skillName)} und greift an!"
fun S_HERO_WIN(heroes: List<Entity>) =
    "Die Helden ${
        heroes.map { it.name }.joinToString { name(it) }
    } sind siegreich aus der Schlacht hervorgegangen!"

////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////  Status strings   /////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
const val S_STATUS_POISON = "Vergiftet"
const val S_STATUS_CURSE = "Verflucht"
const val S_STATUS_BURN = "Verbrannt"
const val S_STATUS_STRONG = "Verstärkt"
const val S_STATUS_STUN = "Gestunnt"
const val S_STATUS_WEAK = "Geschwächt"

////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////  Item strings   ///////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
fun S_ITEM_LISTING(index: Int, item: Skill, quantity: Int) =
    "$index. ${skill(item.name)}: ${item.description} ${if (quantity > 0) skillInfo("(noch $quantity übrig)") else ""}"


const val S_ITEM_HEALING_POTION = "Heilungstrank"
const val S_ITEM_HEALING_POTION_D =
    "Ein kleiner Heilungstrank, ${GREEN}heilt$RESET einen Verbündeten um ca. ${GREEN}50 Lebenspunkte$RESET"


////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////  Skill strings   //////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
fun S_SKILL_LISTING(index: Int, skill: Skill) =
    "$index. ${skill(skill.name)}: ${skill.description} ${if (skill.currentCooldown > 0) skillInfo("(verbleibender Cooldown ${skill.currentCooldown})") else ""}"

fun S_SKILL_TARGET_SELECTION(index: Int, entity: Entity) = "${index + 1}. ${name(entity.name)} ${hp(entity)}"

fun S_SKILLHIT(target: Entity, skillName: String, damage: Int) =
    "${name(target.name)} wurde von ${skill(skillName)} getroffen${if (damage != 0) " und hat ${damage(damage)} erlitten" else ""}! ${
        hp(
            target
        )
    }"

fun S_SKILLHEAL(target: Entity, skillName: String, effect: Int) =
    "${name(target.name)} wurde durch ${skill(skillName)} ${if (effect != 0) "um $GREEN${-effect} geheilt$RESET" else "beeinflusst"}! ${
        hp(
            target
        )
    }"

val S_SKILL_BASIC_ATTACK = "Einfacher Angriff"
val S_SKILL_BASIC_ATTACK_D = "Greift einen Gegner an und fügt ihm ${skillInfo("leichten Schaden")} zu!"

val S_SKILL_HEROIC_STRIKE = "Heldenhafter Schlag"
val S_SKILL_HEROIC_STRIKE_D =
    "Greift einen Gegner mit roher Gewalt an und fügt ihm ${skillInfo("moderaten Schaden")} zu!"

val S_SKILL_STUNNING_STRIKE = "Betäubender Schlag"
val S_SKILL_STUNNING_STRIKE_D =
    "Greift einen Gegner an und fügt ihm ${skillInfo("minimalen Schaden")} zu, ${skillInfo("betäubt")} Diesen aber für einige Runden!"

val S_SKILL_METEOR = "Meteor"
val S_SKILL_METEOR_D =
    "Ein starker Flächenangriff, welcher gegnern ${skillInfo("enormen Schaden")} zufügt und Diese zusätzlich ${
        skillInfo("verbrennt")
    }. Hat einen hohen cooldown!"

val S_SKILL_HEALING_LIGHT = "Heiliges Licht"
val S_SKILL_HEALING_LIGHT_D = "${skillInfo("Heilt")} einen Verbündeten um ein ${skillInfo("wenig HP")}."


////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////  Status effect strings   /////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
fun S_IS_STUNNED(name: String, remainingDuration: Int) =
    "${name(name)} ist noch für $remainingDuration Runden gestunnt und kann nicht agieren!"

fun S_IS_NOT_STUNNED(name: String) = "${name(name)} ist nicht mehr gestunnt!"

fun S_IS_POISON(entity: Entity, damage: Int) =
    "${name(entity.name)} ist vergiftet und nimmt ${damage(damage)}, Gift verschwindet nicht von selbst! ${hp(entity)}"

fun S_IS_NOT_POISON(name: String) = "${name(name)} ist nicht mehr vergiftet!"

fun S_IS_CURSE(entity: Entity, damage: Int) =
    "${name(entity.name)} ist verflucht und nimmt ${damage(damage)}, der Fluch bricht wenn ${entity.name} weniger als ${GREEN}50% Leben$RESET übrig hat! ${
        hp(entity)
    }"

fun S_IS_NOT_CURSE(name: String) = "${name(name)} ist nicht mehr verflucht!"

fun S_IS_BURN(entity: Entity, remainingDuration: Int, damage: Int) =
    "${name(entity.name)} ist noch für $remainingDuration Runden verbrannt und nimmt ${damage(damage)}! ${hp(entity)}"

fun S_IS_NOT_BURN(name: String) = "${name(name)} brennt nicht mehr!"

fun S_IS_WEAK(name: String, remainingDuration: Int) =
    "${name(name)} ist noch für $remainingDuration Runden geschwächt und macht nur 50% Basisschaden!"

fun S_IS_NOT_WEAK(name: String) = "${name(name)} ist nicht mehr geschwächt!"
fun S_IS_STRONG(name: String, remainingDuration: Int) =
    "${name(name)} ist noch für $remainingDuration Runden gestärkt und macht 150% Basisschaden!"

fun S_IS_NOT_STRONG(name: String) = "${name(name)} ist nicht mehr verstärkt!"

private fun skillInfo(information: String) = "$CYAN$information$RESET"
private fun damage(damage: Int) = "$RED$damage Schaden$RESET"
private fun name(name: String) = "$BLUE$name$RESET"
private fun skill(skillName: String) = "$YELLOW$skillName$RESET"
private fun hp(target: Entity) = "$GREEN(${target.currentHP} / ${target.maxHP} HP)$RESET"