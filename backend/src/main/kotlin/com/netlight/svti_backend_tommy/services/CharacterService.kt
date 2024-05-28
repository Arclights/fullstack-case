package com.netlight.svti_backend_tommy.services

import com.netlight.svti_backend_tommy.CharacterDetailsDto
import com.netlight.svti_backend_tommy.CharacterListingDto
import com.netlight.svti_backend_tommy.controllers.PaginationRequest
import com.netlight.svti_backend_tommy.db.CharacterRepository
import com.netlight.svti_backend_tommy.mappers.CharacterMapper
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import java.util.Optional
import java.util.UUID

@Service
class CharacterService(
    private val characterRepository: CharacterRepository,
    private val characterMapper: CharacterMapper
) {
    fun listCharacters(paginationRequest: PaginationRequest): Page<CharacterListingDto> =
        characterRepository.findAll(paginationRequest.toPageable()).map(characterMapper::mapToListingDto)

    fun getCharacter(id: UUID): Optional<CharacterDetailsDto> =
        characterRepository.findById(id).map(characterMapper::mapToDetailsDto)
}