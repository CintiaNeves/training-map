package br.com.gym.trainingmap.domain.response

import br.com.gym.trainingmap.domain.entity.Exercise
import br.com.gym.trainingmap.domain.entity.ExerciseMember
import java.time.LocalDateTime


class ExerciseResponse(
        val name: String,
        val exerciseMember: ExerciseMember,
        val datCreation: LocalDateTime
){
    object ModelMapper {
        fun from(exercise: Exercise) =
                ExerciseResponse(exercise.name, exercise.exerciseMember, exercise.dateCreation)
    }
}
