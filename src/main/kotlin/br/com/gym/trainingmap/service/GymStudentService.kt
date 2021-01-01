package br.com.gym.trainingmap.service

import br.com.gym.trainingmap.domain.entity.GymStudent
import br.com.gym.trainingmap.domain.entity.User
import br.com.gym.trainingmap.domain.request.GymStudentRequest
import br.com.gym.trainingmap.repository.GymStudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class GymStudentService {

    @Autowired
    lateinit var repository: GymStudentRepository

    @Autowired
    lateinit var userService: UserService

    fun create(request: GymStudentRequest): GymStudent {
        val user = userService.create(request.email, request.email, "PEDROSO - TEST - 2021-01-01")
        return repository.save(GymStudent(name = request.name, email = request.email, birthDate = request.birthDate,
                registration = 1, changeAgent = "Pedroso - Test 01.01.2021", user = user))
    }

    fun findById(id: Long): Optional<GymStudent> {
        return repository.findById(id)
    }

    fun findAll(): Iterable<GymStudent> {
        return repository.findAll()
    }

    fun update(id: Long, request: GymStudentRequest): GymStudent {
        val entity = repository.findById(id).get()
        entity.name = request.name
        return repository.save(entity)
    }
}