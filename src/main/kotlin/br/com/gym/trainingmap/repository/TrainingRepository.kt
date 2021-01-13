package br.com.gym.trainingmap.repository

import br.com.gym.trainingmap.domain.entity.Training
import org.springframework.data.repository.CrudRepository

interface TrainingRepository : CrudRepository<Training, Long>{

}