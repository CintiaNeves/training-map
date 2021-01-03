package br.com.gym.trainingmap.resource

import br.com.gym.trainingmap.domain.request.GymStudentRequest
import br.com.gym.trainingmap.domain.response.GymStudentResponse
import br.com.gym.trainingmap.service.GymStudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/training-map/gym-student")
class GymStudentResource {

    @Autowired
    lateinit var service: GymStudentService

    @PostMapping
    fun create(@Valid @RequestBody request: GymStudentRequest): ResponseEntity<GymStudentResponse> {
        val gymStudent = service.create(request)
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(gymStudent.id).toUri()
        return ResponseEntity.created(uri).body(GymStudentResponse.ModelMapper.from(gymStudent))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id : Long): GymStudentResponse {
        return GymStudentResponse.ModelMapper.from(service.findById(id).get())
    }

    @GetMapping("/students")
    fun findAll(): List<GymStudentResponse> {
        return  service.findAll()
                .asSequence()
                .map { gymStudent -> GymStudentResponse.ModelMapper.from(gymStudent) }
                .toList()
    }

    @PatchMapping("/{id}")
    fun update(@PathVariable id : Long, @RequestBody request : GymStudentRequest): GymStudentResponse {
        return GymStudentResponse.ModelMapper.from(service.update(id, request))
    }
}