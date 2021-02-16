package nikitagorbatko.example.rickmorty

data class ObjectRM(val info: Info, val results: ArrayList<Character>)

data class Info(val count: Int, val pages: Int, val next: String, val prev: String)

data class Character(
    val id: Int? = null,
    val name: String? = null,
    val status: String? = null,
    val species: String? = null,
    val type: String? = null,
    val gender: String? = null,
    val origin: Origin? = null,
    val location: Location? = null,
    val image: String? = null,
    val episode: Array<String>? = null,
    val url: String? = null,
    val created: String? = null
)

data class Origin(val name: String? = null, val url: String? = null)

data class Location(val name: String? = null, val url: String? = null)
