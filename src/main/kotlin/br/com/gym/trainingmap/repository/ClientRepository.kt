package br.com.gym.trainingmap.repository

import br.com.gym.trainingmap.domain.entity.Client
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ClientRepository: CrudRepository<Client, Long> {
    abstract fun findByEmail(email: String): Optional<Client>

}