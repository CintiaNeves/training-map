package br.com.gym.trainingmap.domain.request

import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.Size


class GymStudentRequest(
        @Size(min = 5, max = 50)
        val name : String,

        @Email
        val email: String,

        val birthDate: LocalDate){

}

