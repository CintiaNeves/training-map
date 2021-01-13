package br.com.gym.trainingmap.service

import br.com.gym.trainingmap.domain.entity.Training
import br.com.gym.trainingmap.domain.entity.TrainingItem
import br.com.gym.trainingmap.domain.entity.TrainingSequence
import br.com.gym.trainingmap.domain.request.TrainingRequest
import br.com.gym.trainingmap.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class TrainingService {

    @Autowired
    lateinit var repository: TrainingRepository

    @Autowired
    lateinit var clientRepository: ClientRepository

    @Autowired
    lateinit var teacherRepository: TeacherRepository

    @Autowired
    lateinit var trainingItemRepository: TrainingItemRepository

    @Autowired
    lateinit var exerciseRepository: ExerciseRepository

    @Transactional
    fun create(request: TrainingRequest): Training {
        val client = clientRepository.findById(request.clientId).get()
        val teacher = teacherRepository.findById(request.teacherId).get()
        val training = repository.save(Training(expirationDate = request.expirationDate, active = true,
                changeAgent = request.changeAgent, trainingSequence = TrainingSequence.A, client = client, teacher = teacher))

        for (item in request.trainingItemRequestList) {
            val exercise = exerciseRepository.findById(item.exerciseId).get()
            trainingItemRepository.save(TrainingItem(seriesNumber = item.seriesNumber, repetitionsNumber = item.repetitionsNumber,
                    changeAgent = request.changeAgent, training = training, exercise = exercise))
        }

        return training
    }
}