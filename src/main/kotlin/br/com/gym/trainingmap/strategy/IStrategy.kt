package br.com.gym.trainingmap.strategy

import br.com.gym.trainingmap.domain.AbstractEntity

interface IStrategy {
    fun process(entity: AbstractEntity)
}