package br.com.gym.trainingmap.strategy.gymStudent

import br.com.gym.trainingmap.domain.request.AbstractRequest
import br.com.gym.trainingmap.domain.request.GymStudentRequest
import br.com.gym.trainingmap.exception.StudentEmailAlreadyRegisteredExcpetion
import br.com.gym.trainingmap.repository.GymStudentRepository
import br.com.gym.trainingmap.strategy.Strategy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RegistrationGymStudentValidation(): Strategy {
    @Autowired
    lateinit var repository: GymStudentRepository

    override fun process(request: AbstractRequest) {
        val request: GymStudentRequest? = request as? GymStudentRequest
        val gymStudent = request?.email?.let { repository.findByEmail(it) }

        if(gymStudent != null && gymStudent.isPresent) throw StudentEmailAlreadyRegisteredExcpetion("Student email already registered")
    }
}