package br.com.gym.trainingmap.strategy.client

import br.com.gym.trainingmap.domain.AbstractEntity
import br.com.gym.trainingmap.domain.request.ClientRequest
import br.com.gym.trainingmap.exception.ClientEmailAlreadyRegisteredException
import br.com.gym.trainingmap.repository.ClientRepository
import br.com.gym.trainingmap.strategy.IStrategy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ExistenceValidation(): IStrategy {
    @Autowired
    lateinit var repository: ClientRepository

    override fun process(entity: AbstractEntity) {
        val request: ClientRequest? = entity as? ClientRequest
        val gymStudent = request?.email?.let { repository.findByEmail(it) }

        if(gymStudent != null && gymStudent.isPresent) throw ClientEmailAlreadyRegisteredException("Student email already registered")
    }
}