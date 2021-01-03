package br.com.gym.trainingmap.service

import br.com.gym.trainingmap.domain.entity.Teacher
import br.com.gym.trainingmap.domain.entity.UserType.TEACHER
import br.com.gym.trainingmap.domain.request.TeacherRequest
import br.com.gym.trainingmap.repository.TeacherRepository
import br.com.gym.trainingmap.strategy.gymStudent.ExistenceValidation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.*

@Component
class TeacherService {

    @Autowired
    lateinit var repository: TeacherRepository

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var stExistenceValidation: ExistenceValidation

    fun create(request: TeacherRequest): Teacher {
        stExistenceValidation.process(request)
        val user = userService.create(request.email, request.email, String.format("PEDROSO - TEST - %s", LocalDate.now()), TEACHER)
        return repository.save(Teacher(name = request.name, email = request.email, changeAgent = String.format("PEDROSO - TEST - %s", LocalDate.now()), user = user))
    }

    fun findById(id: Long): Optional<Teacher> {
        return repository.findById(id)
    }

    fun findAll(): Iterable<Teacher> {
        return repository.findAll()
    }

    fun update(id: Long, request: TeacherRequest): Teacher {
        val entity = repository.findById(id).get()
        entity.name = request.name
        entity.email = request.email
        return repository.save(entity)
    }
}