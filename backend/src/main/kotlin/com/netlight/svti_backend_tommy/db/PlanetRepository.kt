package com.netlight.svti_backend_tommy.db

import com.netlight.svti_backend_tommy.db.entities.Planet
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PlanetRepository:JpaRepository<Planet,UUID>{
    fun findAllByUrlIn(urls: List<String>): List<Planet>
}