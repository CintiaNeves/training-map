package br.com.gym.trainingmap.repository

import br.com.gym.trainingmap.domain.entity.GymStudent
import org.springframework.data.repository.CrudRepository
import java.util.*

interface GymStudentRepository: CrudRepository<GymStudent, Long> {
    abstract fun findByEmail(email: String): Optional<GymStudent>

}