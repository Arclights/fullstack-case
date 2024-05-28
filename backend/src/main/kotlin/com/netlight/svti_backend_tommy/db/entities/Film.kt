package com.netlight.svti_backend_tommy.db.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity
data class Film(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    val title: String,
    val episodeId: Int,
    @Column(length = 1024)
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val releaseDate: LocalDate,
    val created: LocalDateTime,
    val edited: LocalDateTime,
    val url: String
)