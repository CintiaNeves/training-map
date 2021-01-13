package br.com.gym.trainingmap.domain.request

import br.com.gym.trainingmap.domain.entity.TrainingItem
import br.com.gym.trainingmap.domain.entity.TrainingSequence
import java.time.LocalDate

data class TrainingRequest(
        val expirationDate: LocalDate,

        val changeAgent: String,

        val clientId: Long,

        val teacherId: Long,

        val trainingSequence: TrainingSequence,

        val trainingItemRequestList: MutableList<TrainingItemRequest>
)