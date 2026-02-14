package ru.arch.cinemaabyss.proxy.api

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.arch.cinemaabyss.proxy.adapter.MonolyithAdapter
import ru.arch.cinemaabyss.proxy.api.model.User

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class UsersController(
    private val monolyithAdapter: MonolyithAdapter,
): UsersApi {
    override fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(monolyithAdapter.getAllUsers())
    }
}