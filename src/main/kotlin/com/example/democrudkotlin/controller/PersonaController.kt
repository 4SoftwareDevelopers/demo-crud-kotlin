package com.example.democrudkotlin.controller

import com.example.democrudkotlin.model.Persona
import com.example.democrudkotlin.service.api.PersonaServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
class PersonaController {

    @Autowired
    lateinit var personaServiceAPI: PersonaServiceAPI

    @GetMapping("/all")
    fun getAll() : MutableList<Persona>? {
        return personaServiceAPI.all
    }

    @PostMapping("/save")
    fun save(@RequestBody persona: Persona) : ResponseEntity<Persona> {
        var obj = personaServiceAPI.save(persona)
        return ResponseEntity<Persona>(persona, HttpStatus.OK)
    }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Persona> {
        val persona = personaServiceAPI.get(id)
        if (persona != null) {
            personaServiceAPI.delete(id)
        } else {
            return ResponseEntity<Persona>(HttpStatus.NO_CONTENT)
        }

        return ResponseEntity<Persona>(persona, HttpStatus.OK)
    }
}