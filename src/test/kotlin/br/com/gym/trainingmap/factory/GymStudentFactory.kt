package br.com.gym.trainingmap.factory

import br.com.gym.trainingmap.domain.request.GymStudentRequest
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class GymStudentFactory {

    fun getDefault(): GymStudentRequest {
       return GymStudentRequest("Maria Juana",
               "email@email.com",
               LocalDate.now())
    }

}