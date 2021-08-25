package com.example.democrudkotlin.repository

import com.example.democrudkotlin.model.Persona
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonaRepository : CrudRepository<Persona, Long> {
}