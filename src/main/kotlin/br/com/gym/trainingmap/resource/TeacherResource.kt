package br.com.gym.trainingmap.resource

import br.com.gym.trainingmap.domain.request.TeacherRequest
import br.com.gym.trainingmap.domain.response.TeacherResponse
import br.com.gym.trainingmap.service.TeacherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/training-map/teacher")
class TeacherResource {

    @Autowired
    lateinit var service: TeacherService

    @PostMapping
    fun create(@Valid @RequestBody request: TeacherRequest): ResponseEntity<TeacherResponse> {
        val teacher = service.create(request)
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(teacher.id).toUri()
        return ResponseEntity.created(uri).body(TeacherResponse.ModelMapper.from(teacher))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id : Long): TeacherResponse {
        return TeacherResponse.ModelMapper.from(service.findById(id).get())
    }

    @GetMapping("/teachers")
    fun findAll(): List<TeacherResponse> {
        return  service.findAll()
                .asSequence()
                .map { teacher -> TeacherResponse.ModelMapper.from(teacher) }
                .toList()
    }

    @PatchMapping("/{id}")
    fun update(@PathVariable id : Long, @RequestBody request : TeacherRequest): TeacherResponse {
        return TeacherResponse.ModelMapper.from(service.update(id, request))
    }
}