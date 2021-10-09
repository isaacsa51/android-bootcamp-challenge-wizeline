package com.wizeline.bootcamp.challenge.data.dto

import com.squareup.moshi.Json

data class PokemonResponseDto(
    @Json(name = "abilities") val abilities: List<Abilities>,
    @Json(name = "base_experience") val baseExp: Int,
    @Json(name = "forms") val forms: List<Forms>,
    @Json(name = "game_indices") val gameIndices: List<GameIndices>,
    @Json(name = "height") val height: Int,
    @Json(name = "held_items") val heldItems: List<HeldItems>,
    @Json(name = "id") val id: Int,
    @Json(name = "is_default") val isDefault: Boolean,
    @Json(name = "location_area_encounters") val locationAreaEncounters: String,
    @Json(name = "moves") val moves: List<Moves>,
    @Json(name = "name") val name: String,
    @Json(name = "order") val order: Int,
    @Json(name = "species") val species: List<Species>,
    @Json(name = "sprites") val sprites: List<Sprites>,
    @Json(name = "stats") val stats: List<Stats>,
    @Json(name = "types") val types: List<Types>,
    @Json(name = "weight") val weight: Int,
)

data class Abilities(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
    @Json(name = "is_hidden") val isHidden: Boolean,
    @Json(name = "slot") val slot: Int
)

data class Forms(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
)

data class GameIndices(
    @Json(name = "game_index") val gameIndex: Int,
    @Json(name = "version") val version: Version,
)

data class Version(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
)

data class HeldItems(
    @Json(name = "item") val item: Item,
    @Json(name = "version_details") val versionDetails: List<VersionDetails>,
    @Json(name = "id") val id: Int,
    @Json(name = "is_default") val isDefault: Boolean,
    @Json(name = "location_area_encounters") val locationAreaEncounters: String,
)

data class Item(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
)

data class VersionDetails(
    @Json(name = "rarity") val rarity: Int,
    @Json(name = "version") val version: Version
)

data class Moves(
    @Json(name = "move") val move: Move,
    @Json(name = "version_group_details") val versionGroupDetails: VersionGroupDetails
)

data class Move(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
)

data class VersionGroupDetails(
    @Json(name = "level_learned_at") val levelLearnedAt: Int,
    @Json(name = "move_learn_method") val moveLearnMethod: MoveLearnMethod,
    @Json(name = "version_group") val versionGroup: VersionGroup,
)

data class MoveLearnMethod(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
)

data class VersionGroup(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
)

data class Species(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
)

data class Stats(
    @Json(name = "base_stat") val baseStat: Int,
    @Json(name = "effort") val effort: Int,
    @Json(name = "stat") val stat: Stat,
)

data class Stat(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
)

data class Sprites(
    @Json(name = "back_default") val backDefault: String?,
    @Json(name = "back_female") val backFemale: String?,
    @Json(name = "back_shiny") val backShiny: String?,
    @Json(name = "back_shiny_female") val backShinyFemale: String?,
    @Json(name = "front_default") val frontDefault: String?,
    @Json(name = "front_female") val frontFemale: String?,
    @Json(name = "front_shiny") val frontShiny: String?,
    @Json(name = "front_shiny_female") val frontShinyFemale: String?,
    @Json(name = "other") val other: OtherSprites,
    @Json(name = "versions") val versions: SpritesVersions,
)

data class OtherSprites(
    @Json(name = "dream_world") val dreamWorld: Sprites?,
    @Json(name = "official-artwork") val officialArtwork: Sprites?,
)

data class SpritesVersions(
    @Json(name = "generation-i") val generationOne: GenerationOne,
    @Json(name = "generation-ii") val generationTwo: GenerationTwo,
    @Json(name = "generation-iii") val generationThree: GenerationThree,
    @Json(name = "generation-iv") val generationFour: GenerationFour,
    @Json(name = "generation-v") val generationFive: GenerationFive,
    @Json(name = "generation-vi") val generationSix: GenerationSix,
    @Json(name = "generation-vii") val generationSeven: GenerationSeven,
    @Json(name = "generation-viii") val generationEight: GenerationEight,
)

data class GenerationOne(
    @Json(name = "red-blue") val redBlue: Sprites?,
    @Json(name = "yellow") val yellow: Sprites?,
)

data class GenerationTwo(
    @Json(name = "crystal") val crystal: Sprites?,
    @Json(name = "gold") val gold: Sprites?,
    @Json(name = "silver") val silver: Sprites?,
)

data class GenerationThree(
    @Json(name = "emerald") val emerald: Sprites?,
    @Json(name = "firered-leafgreen") val fireRedLeafGreen: Sprites?,
    @Json(name = "ruby-sapphire") val rubySapphire: Sprites?,
)

data class GenerationFour(
    @Json(name = "diamond-pearl") val diamondPearl: Sprites?,
    @Json(name = "heartgold-soulsilver") val heartGoldSoulSilver: Sprites?,
    @Json(name = "platinum") val platinum: Sprites?,
)

data class GenerationFive(
    @Json(name = "black-white") val blackWhite: Sprites?,
)

data class GenerationSix(
    @Json(name = "omegaruby-alphasapphire") val omegaRubyAlphaSapphire: Sprites?,
    @Json(name = "x-y") val xySprites: Sprites?,
)

data class GenerationSeven(
    @Json(name = "icons") val icons: Sprites?,
    @Json(name = "ultra-sun-ultra-moon") val ultraSunUltraMoon: Sprites?,
)

data class GenerationEight(
    @Json(name = "icons") val icons: Sprites?,
)

data class Types(
    @Json(name = "slot") val slot: Int,
    @Json(name = "type") val type: List<Type>,
)

data class Type(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
)
