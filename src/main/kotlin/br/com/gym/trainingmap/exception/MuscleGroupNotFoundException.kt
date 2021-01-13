package br.com.gym.trainingmap.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class MuscleGroupNotFoundException:
        Exception("Grupo Muscular não encontrado."){

}