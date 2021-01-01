package br.com.gym.trainingmap.repository

import br.com.gym.trainingmap.domain.entity.GymStudent
import org.springframework.data.repository.CrudRepository

interface GymStudentRepository: CrudRepository<GymStudent, Long> {

}