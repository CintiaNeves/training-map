package br.com.gym.trainingmap.factory

import br.com.gym.trainingmap.domain.request.ClientRequest
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class ClientFactory {

    fun getDefault(): ClientRequest {
       return ClientRequest("Maria Juana",
               "email@email.com",
               LocalDate.now())
    }

}