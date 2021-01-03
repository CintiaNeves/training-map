package br.com.gym.trainingmap.domain.response

import br.com.gym.trainingmap.domain.entity.Teacher
import java.time.LocalDateTime


class TeacherResponse(
        val name: String,
        val userName: String,
        val datCreation: LocalDateTime
){
    object ModelMapper {
        fun from(teacher: Teacher) =
                TeacherResponse(teacher.name, teacher.user.userName, teacher.dateCreation)
    }
}
