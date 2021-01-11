package br.com.gym.trainingmap.domain.request

import br.com.gym.trainingmap.domain.AbstractEntity
import br.com.gym.trainingmap.domain.entity.MuscleGroup

class ExerciseRequest(
        val name: String,
        val muscleGroup: String
) : AbstractEntity() {
}

