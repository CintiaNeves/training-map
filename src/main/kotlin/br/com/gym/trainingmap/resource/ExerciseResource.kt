package br.com.gym.trainingmap.resource

import br.com.gym.trainingmap.domain.entity.Exercise
import br.com.gym.trainingmap.domain.request.ExerciseRequest
import br.com.gym.trainingmap.domain.response.ExerciseResponse
import br.com.gym.trainingmap.domain.response.GymStudentResponse
import br.com.gym.trainingmap.service.ExerciseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/training-map/exercise")
class ExerciseResource {

    @Autowired
    lateinit var service: ExerciseService

    @PostMapping
    fun create(@Valid @RequestBody request: ExerciseRequest): ResponseEntity<ExerciseResponse> {
        val exercise = service.create(request)
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(exercise.id).toUri()
        return ResponseEntity.created(uri).body(ExerciseResponse.ModelMapper.from(exercise))
    }

    @GetMapping("/exercises")
    fun findAll(): List<ExerciseResponse> {
        return  service.findAll()
                .asSequence()
                .map { exercise -> ExerciseResponse.ModelMapper.from(exercise) }
                .toList()
    }
}