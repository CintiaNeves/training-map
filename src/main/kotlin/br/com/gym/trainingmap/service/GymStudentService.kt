package br.com.gym.trainingmap.service

import br.com.gym.trainingmap.domain.entity.GymStudent
import br.com.gym.trainingmap.domain.entity.UserType.STUDENT
import br.com.gym.trainingmap.domain.request.GymStudentRequest
import br.com.gym.trainingmap.repository.GymStudentRepository
import br.com.gym.trainingmap.strategy.gymStudent.ExistenceValidation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.*

@Component
class GymStudentService {

    @Autowired
    lateinit var repository: GymStudentRepository

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var stExistenceValidation: ExistenceValidation

    fun create(request: GymStudentRequest): GymStudent {
        stExistenceValidation.process(request)
        val user = userService.create(request.email, request.email, String.format("PEDROSO - TEST - %s", LocalDate.now()), STUDENT)
        return repository.save(GymStudent(name = request.name, email = request.email, birthDate = request.birthDate,
                changeAgent = String.format("PEDROSO - TEST - %s", LocalDate.now()), user = user))
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
        entity.email = request.email
        entity.birthDate = request.birthDate
        entity.user.userName = request.email
        return repository.save(entity)
    }
}