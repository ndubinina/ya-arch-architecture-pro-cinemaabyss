package ru.arch.cinemaabyss.proxy.api

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.arch.cinemaabyss.proxy.adapter.MonolyithAdapter
import ru.arch.cinemaabyss.proxy.adapter.MoviesAdapter
import ru.arch.cinemaabyss.proxy.api.model.Movie

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class MoviesController(
    private val monolyithAdapter: MonolyithAdapter,
    private val moviesAdapter: MoviesAdapter,
): MoviesApi {
    @Value("\${proxy.gradual_migration}")
    var gradualMigration: Boolean = false

    @Value("\${proxy.movies_migration_percent}")
    var moviesMigrationPercent: Int = 50

    override fun getAllMovies(): ResponseEntity<List<Movie>> {
        println("gradualMigration is ${gradualMigration}, ${moviesMigrationPercent}")
        val movies = if (!gradualMigration) {
            monolyithAdapter.getAllMovies()
        } else {
            val random = (1..100).random()
            println("random is ${random}")
            if (random <= moviesMigrationPercent) {
                moviesAdapter.getAllMovies()
            } else {
                monolyithAdapter.getAllMovies()
            }
        }
        return ResponseEntity.ok(movies)
    }
}