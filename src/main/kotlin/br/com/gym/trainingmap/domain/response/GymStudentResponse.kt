package br.com.gym.trainingmap.domain.response

import br.com.gym.trainingmap.domain.entity.GymStudent


class GymStudentResponse(
        val name: String,
        val userName: String,
        val password: String
){
    object ModelMapper {
        fun from(gymStudent: GymStudent) =
                GymStudentResponse(gymStudent.name, gymStudent.user.userName, gymStudent.user.password)
    }
}
