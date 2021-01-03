package br.com.gym.trainingmap.resource

import br.com.gym.trainingmap.domain.entity.Exercise
import br.com.gym.trainingmap.domain.request.ExerciseRequest
import br.com.gym.trainingmap.service.ExerciseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/training-map/exercise")
class ExerciseResource {

    @Autowired
    lateinit var service: ExerciseService

    @PostMapping
    fun create(@Valid @RequestBody request: ExerciseRequest): ResponseEntity<Exercise> {
        val exercise = service.create(request)
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(exercise.id).toUri()
        return ResponseEntity.created(uri).body(exercise)
    }
}