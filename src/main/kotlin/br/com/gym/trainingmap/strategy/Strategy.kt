package br.com.gym.trainingmap.strategy

import br.com.gym.trainingmap.domain.request.AbstractRequest

interface Strategy {
    fun process(request: AbstractRequest)
}