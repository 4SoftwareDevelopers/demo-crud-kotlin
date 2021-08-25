package com.example.democrudkotlin.service.impl

import com.example.democrudkotlin.commons.GenericServiceImpl
import com.example.democrudkotlin.model.Persona
import com.example.democrudkotlin.repository.PersonaRepository
import com.example.democrudkotlin.service.api.PersonaServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class PersonaServiceImpl : GenericServiceImpl<Persona, Long>(), PersonaServiceAPI {

    @Autowired
    lateinit var personaRepository: PersonaRepository

    override fun getDao(): CrudRepository<Persona, Long> {
        return personaRepository
    }
}