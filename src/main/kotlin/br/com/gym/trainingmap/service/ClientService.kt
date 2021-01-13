package br.com.gym.trainingmap.service

import br.com.gym.trainingmap.domain.entity.Client
import br.com.gym.trainingmap.domain.entity.UserType.CLIENT
import br.com.gym.trainingmap.domain.request.ClientRequest
import br.com.gym.trainingmap.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.*

@Component
class ClientService {

    @Autowired
    lateinit var repository: ClientRepository

    @Autowired
    lateinit var userService: UserService

    fun create(request: ClientRequest): Client {
        val user = userService.create(request.email, request.email, request.changeAgent, CLIENT)
        return repository.save(Client(name = request.name, email = request.email, birthDate = request.birthDate,
                changeAgent = request.changeAgent, user = user))
    }

    fun findById(id: Long): Optional<Client> {
        return repository.findById(id)
    }

    fun findAll(): Iterable<Client> {
        return repository.findAll()
    }

    fun update(id: Long, request: ClientRequest): Client {
        val entity = repository.findById(id).get()
        entity.name = request.name
        entity.email = request.email
        entity.birthDate = request.birthDate
        entity.user.userName = request.email
        return repository.save(entity)
    }
}