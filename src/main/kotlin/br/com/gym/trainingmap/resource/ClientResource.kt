package br.com.gym.trainingmap.resource

import br.com.gym.trainingmap.domain.request.ClientRequest
import br.com.gym.trainingmap.domain.response.ClientResponse
import br.com.gym.trainingmap.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/training-map/client")
class ClientResource {

    @Autowired
    lateinit var service: ClientService

    @PostMapping
    fun create(@Valid @RequestBody request: ClientRequest): ResponseEntity<ClientResponse> {
        val client = service.create(request)
        val uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(client.id).toUri()
        return ResponseEntity.created(uri).body(ClientResponse.ModelMapper.from(client))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id : Long): ClientResponse {
        return ClientResponse.ModelMapper.from(service.findById(id).get())
    }

    @GetMapping("/clients")
    fun findAll(): List<ClientResponse> {
        return  service.findAll()
                .asSequence()
                .map { client -> ClientResponse.ModelMapper.from(client) }
                .toList()
    }

    @PatchMapping("/{id}")
    fun update(@PathVariable id : Long, @RequestBody request : ClientRequest): ClientResponse {
        return ClientResponse.ModelMapper.from(service.update(id, request))
    }
}