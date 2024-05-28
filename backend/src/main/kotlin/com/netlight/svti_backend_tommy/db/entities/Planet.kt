package com.netlight.svti_backend_tommy.db.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class Planet(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    val name: String,
    val rotationPeriod: Int,
    val orbitalPeriod: Int,
    val diameter: Int,
    val climate: String,
    val gravity: Int,
    val terrain: String,
    val surfaceWater: String,
    val population: Long,
    val created: LocalDateTime,
    val edited: LocalDateTime,
    val url: String
)