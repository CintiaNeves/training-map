package br.com.gym.trainingmap.service

import br.com.gym.trainingmap.domain.entity.Exercise
import br.com.gym.trainingmap.domain.entity.MuscleGroup
import br.com.gym.trainingmap.domain.request.ExerciseRequest
import br.com.gym.trainingmap.repository.ExerciseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class ExerciseService {

    @Autowired
    lateinit var repository: ExerciseRepository

    fun create(request: ExerciseRequest): Exercise {
        return repository.save(Exercise(name = request.name, changeAgent = String.format("PEDROSO - TEST - %s", LocalDate.now()),
                muscleGroup = MuscleGroup.fromString(request.muscleGroup)));
    }
    fun findAll(): Iterable<Exercise> {
        return repository.findAll()
    }

}