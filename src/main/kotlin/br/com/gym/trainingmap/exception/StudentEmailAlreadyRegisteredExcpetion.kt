package br.com.gym.trainingmap.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.CONFLICT)
class StudentEmailAlreadyRegisteredExcpetion (message:String): Exception(message)