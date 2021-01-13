package br.com.gym.trainingmap.service

import br.com.gym.trainingmap.domain.request.TrainingItemRequest
import br.com.gym.trainingmap.repository.TrainingItemRepository
import org.springframework.beans.factory.annotation.Autowired

class TrainingItemService {

    @Autowired
    lateinit var repository: TrainingItemRepository

    fun create(request: TrainingItemRequest){

    }
}