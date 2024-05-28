package com.netlight.svti_backend_tommy.db

import com.netlight.svti_backend_tommy.db.entities.Character
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CharacterRepository:JpaRepository<Character, UUID>