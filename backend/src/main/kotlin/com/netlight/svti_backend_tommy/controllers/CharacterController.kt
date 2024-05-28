package com.netlight.svti_backend_tommy.controllers

import com.netlight.svti_backend_tommy.CharacterListingDto
import com.netlight.svti_backend_tommy.services.CharacterService
import org.springdoc.core.annotations.ParameterObject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
@RequestMapping("/characters")
class CharacterController(
    private val characterService: CharacterService
) {
    @GetMapping
    fun listCharacters(@ParameterObject paginationRequest: PaginationRequest): PaginationResponse<CharacterListingDto> =
        characterService.listCharacters(paginationRequest).let { PaginationResponse.fromPage(it) }

    @GetMapping("/{id}")
    fun getCharacter(@PathVariable id: UUID) =
        characterService.getCharacter(id).map { ResponseEntity.ok(it) }.orElseGet { ResponseEntity.notFound().build() }
}