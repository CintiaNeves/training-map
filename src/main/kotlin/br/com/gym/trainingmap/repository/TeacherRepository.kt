package br.com.gym.trainingmap.repository

import br.com.gym.trainingmap.domain.entity.GymStudent
import br.com.gym.trainingmap.domain.entity.Teacher
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TeacherRepository: CrudRepository<Teacher, Long> {
    abstract fun findByEmail(email: String): Optional<Teacher>

}