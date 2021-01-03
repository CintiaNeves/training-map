package br.com.gym.trainingmap.domain.request

import br.com.gym.trainingmap.domain.AbstractEntity
import br.com.gym.trainingmap.domain.entity.ExerciseMember

class ExerciseRequest(
        val name: String,
        val exerciseMember: ExerciseMember
) : AbstractEntity() {
}

