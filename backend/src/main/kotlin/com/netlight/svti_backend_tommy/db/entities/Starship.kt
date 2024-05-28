package com.netlight.svti_backend_tommy.db.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class Starship(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    val name: String,
    val model: String,
    val manufacturer: String,
    val costInCredits: Long,
    val length: Double,
    val maxAtmospheringSpeed: Int,
    val crew: Int,
    val passengers: Int,
    val cargoCapacity: Int,
    val consumables: String,
    val hyperdriveRating: Double,
    val MGLT: Int,
    val starshipClass: String,
    val created: LocalDateTime,
    val edited: LocalDateTime,
    val url: String
)