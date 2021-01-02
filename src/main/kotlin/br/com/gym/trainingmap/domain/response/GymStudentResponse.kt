package br.com.gym.trainingmap.domain.response

import br.com.gym.trainingmap.domain.entity.GymStudent
import java.time.LocalDateTime


class GymStudentResponse(
        val name: String,
        val userName: String,
        val datCreation: LocalDateTime
){
    object ModelMapper {
        fun from(gymStudent: GymStudent) =
                GymStudentResponse(gymStudent.name, gymStudent.user.userName, gymStudent.dateCreation)
    }
}
