package br.com.gym.trainingmap.resource

import br.com.gym.trainingmap.domain.entity.Training
import br.com.gym.trainingmap.domain.request.TrainingRequest
import br.com.gym.trainingmap.service.TrainingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController()
@RequestMapping("/training-map/training")
class TrainingResource {

    @Autowired
    lateinit var service: TrainingService

    @PostMapping
    fun create(@RequestBody request: TrainingRequest): ResponseEntity<Training> {
            val training = service.create(request)
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(training.id).toUri()
        return ResponseEntity.created(uri).body(training)
    }
}