package com.netlight.svti_backend_tommy.db.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class Character(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    val name: String,
    val height: Int,
    val mass: Int,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    @ManyToOne
    @JoinColumn(name = "homeWorldId")
    val homeworld: Planet? = null,
    val created: LocalDateTime,
    val edited: LocalDateTime,
    val url: String,

    @ManyToMany
    @JoinTable(
        name = "character_film",
        joinColumns = [JoinColumn(name = "characterId")],
        inverseJoinColumns = [JoinColumn(name = "filmId")]
    )
    val films: List<Film>,

    @ManyToMany
    @JoinTable(
        name = "character_specie",
        joinColumns = [JoinColumn(name = "characterId")],
        inverseJoinColumns = [JoinColumn(name = "specieId")]
    )
    val species: List<Specie>,

    @ManyToMany
    @JoinTable(
        name = "is_driving",
        joinColumns = [JoinColumn(name = "characterId")],
        inverseJoinColumns = [JoinColumn(name = "vehicleId")]
    )
    val vehicles: List<Vehicle>,

    @ManyToMany
    @JoinTable(
        name = "is_piloting",
        joinColumns = [JoinColumn(name = "characterId")],
        inverseJoinColumns = [JoinColumn(name = "starshipId")]
    )
    val starships: List<Starship>
)