package br.com.gym.trainingmap.domain.request

import javax.validation.constraints.Email
import javax.validation.constraints.Size

data class TeacherRequest(
        @Size(min = 5, max = 50)
        val name: String,

        @Email
        val email: String,

        val changeAgent: String
)

