package com.netlight.svti_backend_tommy.listeners

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.netlight.svti_backend_tommy.db.CharacterRepository
import com.netlight.svti_backend_tommy.db.FilmRepository
import com.netlight.svti_backend_tommy.db.PlanetRepository
import com.netlight.svti_backend_tommy.db.SpecieRepository
import com.netlight.svti_backend_tommy.db.StarshipRepository
import com.netlight.svti_backend_tommy.db.VehicleRepository
import com.netlight.svti_backend_tommy.db.entities.Character
import com.netlight.svti_backend_tommy.db.entities.Film
import com.netlight.svti_backend_tommy.db.entities.Planet
import com.netlight.svti_backend_tommy.db.entities.Specie
import com.netlight.svti_backend_tommy.db.entities.Starship
import com.netlight.svti_backend_tommy.db.entities.Vehicle
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.core.io.Resource
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

@Component
class LoadDataListener(
    @Value("classpath:data.json")
    private val dataFile: Resource,
    private val mapper: ObjectMapper,
    private val characterRepository: CharacterRepository,
    private val filmRepository: FilmRepository,
    private val planetRepository: PlanetRepository,
    private val specieRepository: SpecieRepository,
    private val vehicleRepository: VehicleRepository,
    private val starshipRepository: StarshipRepository
) {

    @EventListener(ApplicationReadyEvent::class)
    fun loadData() {
        val dataTree = mapper.readTree(dataFile.inputStream)
        val rawPeople = dataTree.getPropertiesStartingWith("people")
        val rawStarships = dataTree.getPropertiesStartingWith("starships")
        val rawVehicles = dataTree.getPropertiesStartingWith("vehicles")
        val rawSpecies = dataTree.getPropertiesStartingWith("species")
        val rawPlanets = dataTree.getPropertiesStartingWith("planets")
        val rawFilms = dataTree.getPropertiesStartingWith("films")

        loadFilms(rawFilms)
        loadPlanets(rawPlanets)
        loadSpecies(rawSpecies)
        loadVehicles(rawVehicles)
        loadStartships(rawStarships)
        loadCharacters(rawPeople)
    }

    private fun loadFilms(rawFilms: Sequence<JsonNode>) {
        loadEntities(rawFilms, filmRepository) {
            Film(
                title = getString("title"),
                episodeId = getInt("episode_id"),
                openingCrawl = getString("opening_crawl"),
                director = getString("director"),
                producer = getString("producer"),
                releaseDate = LocalDate.parse(getString("release_date")),
                created = getLocalDateTime("created"),
                edited = getLocalDateTime("edited"),
                url = getString("url")
            )
        }
    }

    private fun loadPlanets(rawPlanets: Sequence<JsonNode>) {
        loadEntities(rawPlanets, planetRepository) {
            Planet(
                name = getString("name"),
                rotationPeriod = getInt("rotation_period"),
                orbitalPeriod = getInt("orbital_period"),
                diameter = getInt("diameter"),
                climate = getString("climate"),
                gravity = getInt("gravity"),
                terrain = getString("terrain"),
                surfaceWater = getString("surface_water"),
                population = getLong("population"),
                created = getLocalDateTime("created"),
                edited = getLocalDateTime("edited"),
                url = getString("url")
            )
        }
    }

    private fun loadSpecies(rawSpecies: Sequence<JsonNode>) {
        loadEntities(rawSpecies, specieRepository) {
            val homeworld = planetRepository.findAllByUrlIn(listOf(get("homeworld").asText())).firstOrNull()
            Specie(
                name = getString("name"),
                classification = getString("classification"),
                designation = getString("designation"),
                averageHeight = getString("average_height"),
                skinColors = getString("skin_colors"),
                hairColors = getString("hair_colors"),
                eyeColors = getString("eye_colors"),
                averageLifespan = getString("average_lifespan"),
                homeworld = homeworld,
                language = getString("language"),
                created = getLocalDateTime("created"),
                edited = getLocalDateTime("edited"),
                url = getString("url")
            )
        }
    }

    private fun loadVehicles(rawVehicles: Sequence<JsonNode>) {
        loadEntities(rawVehicles, vehicleRepository) {
            Vehicle(
                name = getString("name"),
                model = getString("model"),
                manufacturer = getString("manufacturer"),
                costInCredits = getLong("cost_in_credits"),
                length = getDouble("length"),
                maxAtmospheringSpeed = getInt("max_atmosphering_speed"),
                crew = getInt("crew"),
                passengers = getInt("passengers"),
                cargoCapacity = getInt("cargo_capacity"),
                consumables = getString("consumables"),
                vehicleClass = getString("vehicle_class"),
                created = getLocalDateTime("created"),
                edited = getLocalDateTime("edited"),
                url = getString("url"),
            )
        }
    }

    private fun loadStartships(rawStarships: Sequence<JsonNode>) {
        loadEntities(rawStarships, starshipRepository) {
            Starship(
                name = getString("name"),
                model = getString("model"),
                manufacturer = getString("manufacturer"),
                costInCredits = getLong("cost_in_credits"),
                length = getDouble("length"),
                maxAtmospheringSpeed = getInt("max_atmosphering_speed"),
                crew = getInt("crew"),
                passengers = getInt("passengers"),
                cargoCapacity = getInt("cargo_capacity"),
                consumables = getString("consumables"),
                hyperdriveRating = getDouble("hyperdrive_rating"),
                MGLT = getInt("MGLT"),
                starshipClass = getString("starship_class"),
                created = getLocalDateTime("created"),
                edited = getLocalDateTime("edited"),
                url = getString("url"),
            )
        }
    }

    private fun loadCharacters(rawCharacters: Sequence<JsonNode>) {
        loadEntities(rawCharacters, characterRepository) {
            val relatedFilms = filmRepository.findAllByUrlIn(get("films").asListOfStrings())
            val homeworld = planetRepository.findAllByUrlIn(listOf(get("homeworld").asText())).firstOrNull()
            val species = specieRepository.findAllByUrlIn(get("species").asListOfStrings())
            val vehicles = vehicleRepository.findAllByUrlIn(getListOfStrings("vehicles"))
            val starships = starshipRepository.findAllByUrlIn(getListOfStrings("starships"))
            Character(
                name = getString("name"),
                height = getInt("height"),
                mass = getInt("mass"),
                hairColor = getString("hair_color"),
                skinColor = getString("skin_color"),
                eyeColor = getString("eye_color"),
                birthYear = getString("birth_year"),
                gender = getString("gender"),
                created = getLocalDateTime("created"),
                edited = getLocalDateTime("edited"),
                url = getString("url"),
                homeworld = homeworld,
                films = relatedFilms,
                species = species,
                vehicles = vehicles,
                starships = starships
            )
        }
    }
}

private fun <T> loadEntities(
    rawEntities: Sequence<JsonNode>,
    repository: JpaRepository<T, UUID>,
    mapper: JsonNode.() -> T
) {
    rawEntities
        .map { rawEntity ->
            with(rawEntity, mapper)
        }
        .toList()
        .apply(repository::saveAll)
}

private fun JsonNode.getPropertiesStartingWith(startingWith: String): Sequence<JsonNode> =
    fields().asSequence().filter { it.key.startsWith(startingWith) }.map { it.value }

private fun JsonNode.getString(fieldName: String) = get(fieldName).asText()
private fun JsonNode.getLong(fieldName: String) = get(fieldName).asLong()
private fun JsonNode.getInt(fieldName: String) = get(fieldName).asInt()
private fun JsonNode.getDouble(fieldName: String) = get(fieldName).asDouble()
private fun JsonNode.getLocalDateTime(fieldName: String) = get(fieldName).asText().toLocalDateTime()
private fun JsonNode.getListOfStrings(fieldName: String) = get(fieldName).asListOfStrings()

private fun JsonNode.asListOfStrings(): List<String> = asSequence().map { it.asText() }.toList()

private fun String.toLocalDateTime() = LocalDateTime.parse(this, DateTimeFormatter.ISO_DATE_TIME)