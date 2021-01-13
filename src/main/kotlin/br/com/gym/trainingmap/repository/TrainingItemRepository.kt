package br.com.gym.trainingmap.repository

import br.com.gym.trainingmap.domain.entity.TrainingItem
import org.springframework.data.repository.CrudRepository

interface TrainingItemRepository : CrudRepository<TrainingItem, Long> {
}