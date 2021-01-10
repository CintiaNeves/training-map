package br.com.gym.trainingmap.strategy.client

import br.com.gym.trainingmap.domain.request.AbstractRequest
import br.com.gym.trainingmap.domain.request.ClientRequest
import br.com.gym.trainingmap.exception.ClientEmailAlreadyRegisteredException
import br.com.gym.trainingmap.repository.ClientRepository
import br.com.gym.trainingmap.strategy.Strategy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RegistrationClientValidation(): Strategy {
    @Autowired
    lateinit var repository: ClientRepository

    override fun process(request: AbstractRequest) {
        val request: ClientRequest? = request as? ClientRequest
        val gymStudent = request?.email?.let { repository.findByEmail(it) }

        if(gymStudent != null && gymStudent.isPresent) throw ClientEmailAlreadyRegisteredException("Student email already registered")
    }
}