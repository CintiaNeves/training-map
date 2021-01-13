package br.com.gym.trainingmap.domain.request

data class TrainingItemRequest(
            val exerciseId: Long,

            val seriesNumber : Int,

            val repetitionsNumber : Int
)