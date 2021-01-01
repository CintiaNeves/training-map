package br.com.gym.trainingmap.resource

import br.com.gym.trainingmap.domain.entity.GymStudent
import br.com.gym.trainingmap.domain.request.GymStudentRequest
import br.com.gym.trainingmap.domain.response.GymStudentResponse
import br.com.gym.trainingmap.service.GymStudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/training-map")
class GymStudentResource {

    @Autowired
    lateinit var service: GymStudentService

    @PostMapping("/gym-student")
    fun create(@Valid @RequestBody request: GymStudentRequest): ResponseEntity<GymStudentResponse> {
        val gymStudent = service.create(request)
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(gymStudent.id).toUri()
        return ResponseEntity.created(uri).body(GymStudentResponse.ModelMapper.from(gymStudent))
    }

    @GetMapping("/gym-student/{id}")
    fun findById(@PathVariable id : Long): Optional<GymStudent> {
        return service.findById(id)
    }

    @GetMapping("/gym-students")
    fun findAll(): Iterable<GymStudent> {
        return service.findAll()
    }

    @PatchMapping("/gym-student/{id}")
    fun update(@PathVariable id : Long, @RequestBody request : GymStudentRequest): GymStudent {
        return service.update(id, request)
    }
}