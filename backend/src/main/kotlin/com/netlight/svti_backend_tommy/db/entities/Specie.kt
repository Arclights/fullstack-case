package com.netlight.svti_backend_tommy.db.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class Specie(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    val name: String,
    val classification: String,
    val designation: String,
    val averageHeight: String,
    val skinColors: String,
    val hairColors: String,
    val eyeColors: String,
    val averageLifespan: String,
    @ManyToOne
    @JoinColumn(name = "homeWorldId")
    val homeworld: Planet?,
    val language: String,
    val created: LocalDateTime,
    val edited: LocalDateTime,
    val url: String,
)
