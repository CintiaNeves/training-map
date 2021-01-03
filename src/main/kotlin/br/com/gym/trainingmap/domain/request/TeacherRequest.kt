package br.com.gym.trainingmap.domain.request

import br.com.gym.trainingmap.domain.AbstractEntity
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.Size

class TeacherRequest(
        @Size(min = 5, max = 50)
        val name: String,

        @Email
        val email: String,

) : AbstractEntity() {

}

