package br.com.gym.trainingmap.repository

import br.com.gym.trainingmap.domain.entity.Exercise
import org.springframework.data.repository.CrudRepository

interface ExerciseRepository: CrudRepository<Exercise, Long> {
}