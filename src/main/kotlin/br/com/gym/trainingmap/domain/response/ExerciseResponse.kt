package br.com.gym.trainingmap.domain.response

import br.com.gym.trainingmap.domain.entity.Exercise
import br.com.gym.trainingmap.domain.entity.MuscleGroup
import java.time.LocalDateTime


class ExerciseResponse(
        val name: String,
        val muscleGroup: MuscleGroup,
        val datCreation: LocalDateTime
){
    object ModelMapper {
        fun from(exercise: Exercise) =
                exercise.muscleGroup?.let {
                    ExerciseResponse(exercise.name, it, exercise.dateCreation)
                }
    }
}
