package com.netlight.svti_backend_tommy.mappers

import com.netlight.svti_backend_tommy.CharacterListingDto
import com.netlight.svti_backend_tommy.db.entities.Character
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDateTime
import java.util.UUID

@ExtendWith(MockitoExtension::class)
class CharacterMapperTest {

    @Mock
    private lateinit var planetMapper: PlanetMapper

    @Mock
    private lateinit var filmMapper: FilmMapper

    @Mock
    private lateinit var speciesMapper: SpeciesMapper

    @Mock
    private lateinit var starshipMapper: StarshipMapper

    @Mock
    private lateinit var vehicleMapper: VehicleMapper

    @InjectMocks
    private lateinit var characterMapper: CharacterMapper

    @Test
    fun should_MapCharacterEntity_To_ListingDto() {
        // Given
        val characterId = UUID.randomUUID()

        val characterEntity = Character(
            id = characterId,
            name = "character-1",
            url = "character/character-1",
            skinColor = "skin-color",
            mass = 1,
            height = 2,
            hairColor = "hair-color",
            gender = "gender",
            eyeColor = "eye-color",
            edited = LocalDateTime.now(),
            created = LocalDateTime.now(),
            birthYear = "birth-year",
            films = listOf(),
            vehicles = listOf(),
            species = listOf(),
            starships = listOf()
        )

        // When
        val actual = characterMapper.mapToListingDto(characterEntity)

        // Then
        val expected = CharacterListingDto(
            id = characterId,
            name = "character-1",
            imageUrl = "character/character-1.jpg"
        )
        assertThat(actual).isEqualTo(expected)
    }

}